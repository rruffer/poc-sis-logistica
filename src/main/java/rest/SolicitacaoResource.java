package rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;

import dto.SolicitacaoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Solicitacao;
//import service.SolicitacaoService;
import service.SolicitacaoService;

@Stateless
@Path("/solicitacao")
@Api(value = "Solicitacao")
public class SolicitacaoResource {

	@Inject
	private SolicitacaoService solicitacaoTrans;
	
	private ModelMapper mapper = new ModelMapper();

	@POST
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@ApiOperation(value = "Receber solicitação")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Solicitação gravada com sucesso!"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") 
			})
	public Response receberSolicitacao(SolicitacaoDTO solicitacaoDTO) {

		Solicitacao solicitacao = null;
		
		try {

			solicitacao  = mapper.map(solicitacaoDTO, Solicitacao.class);
			solicitacao = solicitacaoTrans.salvarSolicitacao(solicitacao);

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(solicitacao).build();
		}

		return Response.status(Status.OK).entity(solicitacao).build();
	}

}
