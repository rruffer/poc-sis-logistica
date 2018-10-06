package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.SolicitacaoDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Solicitacao;

@Path("/solicitacao")
@Api(value = "Solicitacao")
@Stateless
public class ServiceSolicitacao {

	@Inject
	private SolicitacaoDAO dao;


/*	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@ApiOperation(value = "Excluir solicitação por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Solicitação removida com sucesso"),
			@ApiResponse(code = 204, message = "Nenhum conteúdo") })
	public Response excluir(@PathParam("id") Long id) {
		Response response = Response.status(204).entity("Solicitação não encontrada").build();
		
		Solicitacao solicitacao = dao.find(id);

		if (solicitacao != null) {
			dao.remove(solicitacao);
			response = Response.status(200).entity(solicitacao).build();
		}

		return response;
	}*/

	@POST
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@ApiOperation(value = "Receber solicitação")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Solicitação recebida"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") })
	public Response receberSolicitacao(Solicitacao solicitacao) {

		try {

			dao.save(solicitacao);

		} catch (NoResultException e) {
			e.printStackTrace();
		}

		return Response.status(201).entity(solicitacao).build();
	}

}
