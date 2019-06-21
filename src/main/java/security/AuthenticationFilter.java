package security;

import java.io.IOException;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Jwts;

@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    private static final String REALM = "sapc";
    //private static final String AUTHENTICATION_SCHEME = "Agro";
    private static final String AUTHENTICATION_SCHEME = "SAPC";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the Authorization header from the request
        String authorizationHeader =
                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Validate the Authorization header
        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized(requestContext);
            return;
        }

        // Extract the token from the Authorization header
        String token = authorizationHeader
                            .substring(AUTHENTICATION_SCHEME.length()).trim();
        
    	final SecurityContext currentSecurityContext = requestContext.getSecurityContext();
    	requestContext.setSecurityContext(new SecurityContext() {

	        @Override
	        public Principal getUserPrincipal() {
				String user = Jwts.parser().setSigningKey("").parseClaimsJws(token.replace("", ""))
						.getBody().getSubject();    	        	
	            return () -> user;
	        }

    	    @Override
    	    public boolean isUserInRole(String role) {
    	        return true;
    	    }

    	    @Override
    	    public boolean isSecure() {
    	        return currentSecurityContext.isSecure();
    	    }

    	    @Override
    	    public String getAuthenticationScheme() {
    	        return AUTHENTICATION_SCHEME;
    	    }
    	});    	
    	
        try {

            // Validate the token
            validateToken(token);

        } catch (Exception e) {
            abortWithUnauthorized(requestContext);
        }
    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {

    	return false;
        // Check if the Authorization header is valid
        // It must not be null and must be prefixed with "Bearer" plus a whitespace
        // The authentication scheme comparison must be case-insensitive
//        return authorizationHeader != null && authorizationHeader.toLowerCase()
//                    .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, 
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .build());
    }
    
    @Context SecurityContext securityContext;
    
    private void validateToken(String token) throws Exception {
        // Check if the token was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
    	
		if (token != null) {
			String userName = securityContext.getUserPrincipal().getName();
			
/*			if (!Jwts.parser().setSigningKey(AuthenticationEndpoint.SECRET).parseClaimsJws(token.replace(AuthenticationEndpoint.TOKEN_PREFIX, "")).getBody().getSubject().equals(userName)) {
				throw new Exception("Invalid Token!");
			}*/
				
//			String user = Jwts.parser().setSigningKey(AuthenticationEndpoint.SECRET).parseClaimsJws(token.replace(AuthenticationEndpoint.TOKEN_PREFIX, ""))
//					.getBody().getSubject();
		}
    }
}