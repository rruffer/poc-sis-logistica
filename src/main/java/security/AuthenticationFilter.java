package security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Principal;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import exception.AutenticacaoException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import model.Autenticacao;
import model.TipoEsquema;
import service.AutenticacaoService;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	private static final String REALM = "sapc";
	private static final String AUTHENTICATION_SCHEME = "SAPC";

	@Inject
	private AutenticacaoService autenticacaoService;

	@Context
	private SecurityContext securityContext;

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		try {

			String token = getToken(requestContext);

			TipoEsquema esquema = getEsquema();

			Autenticacao autenticacao = getAutenticacao(esquema);

			requestContext.setSecurityContext(getSecurityContext(requestContext, token, autenticacao));

			validateToken(token, autenticacao);

/*		} catch (ExpiredJwtException|MalformedJwtException|SignatureException|IllegalArgumentException e) {
			abortarRequisicao(requestContext, e);*/
		} catch (Exception e) {
			abortarRequisicao(requestContext, e);
		} 
		
	}

	private SecurityContext getSecurityContext(ContainerRequestContext requestContext, String token, Autenticacao autenticacao) {
		return new SecurityContext() {

			@Override
			public Principal getUserPrincipal() {
				
				String user = Jwts.parser().setSigningKey(autenticacao.getChave()).parseClaimsJws(token)
						.getBody().getSubject();
				
				
				return () -> user;
			}

			@Override
			public boolean isUserInRole(String role) {
				return true;
			}

			@Override
			public boolean isSecure() {
				return requestContext.getSecurityContext().isSecure();
			}

			@Override
			public String getAuthenticationScheme() {
				return AUTHENTICATION_SCHEME;
			}
		};

	}

	private Autenticacao getAutenticacao(TipoEsquema esquema) throws AutenticacaoException {

		Autenticacao autenticacao = autenticacaoService.obterAutenticacaoPorEsquema(esquema);

		if (autenticacao == null) {
			throw new AutenticacaoException("Token inválido!");
		}

		return autenticacao;
	}

	private String getToken(ContainerRequestContext requestContext) throws AutenticacaoException {
		String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

		if (token == null) {
			throw new AutenticacaoException("Não há token!");
		}

		return token;
	}

	private TipoEsquema getEsquema() throws AutenticacaoException {

		TipoEsquema esquema = null;
		Method method = resourceInfo.getResourceMethod();
		Class<?> clazz = resourceInfo.getResourceClass();

		if (method.isAnnotationPresent(Secured.class)) {
			esquema = method.getAnnotation(Secured.class).esquema();
		} else if (clazz.isAnnotationPresent(Secured.class)) {
			esquema = clazz.getAnnotation(Secured.class).esquema();
		}

		if (esquema == null || esquema.equals(TipoEsquema.NONE)) {
			throw new AutenticacaoException("Esquema inválido!");
		}

		return esquema;
	}

	private void abortarRequisicao(ContainerRequestContext requestContext, Exception e) {
		
		String msg = e.getMessage();
		
		if(e instanceof SignatureException) {
			msg = "Token inválido";
		}

		// Abort the filter chain with a 401 status code response
		// The WWW-Authenticate header is sent along with the response
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"").entity(msg).build());
	}

	private void validateToken(String token, Autenticacao autenticacao) throws AutenticacaoException {
		// Check if the token was issued by the server and if it's not expired
		// Throw an Exception if the token is invalid

		if (token != null) {
			String userName = securityContext.getUserPrincipal().getName();

			if (!userName.equals(autenticacao.getUsuario())) {
				throw new AutenticacaoException("Token inválido!");
			}

		}
	}
}