package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import dto.TokenDTO;
import model.Autenticacao;
import rest.doc.AutenticacaoResource;
import service.AutenticacaoService;

@Stateless
public class AutenticacaoResourceImp implements AutenticacaoResource {
	
	@Inject
	private AutenticacaoService autenticacaoService;

	@Override
	public Response obterToken(String usuario, String senha) {
		
		Autenticacao autenticacao = autenticacaoService.obterAutenticacao(usuario, senha);
		
		if(autenticacao  == null) {
			return Response.noContent().build();
		}
		
		TokenDTO token = autenticacaoService.obterToken(autenticacao); 

		return Response.ok().entity(token).build();
	}

	
	
}
