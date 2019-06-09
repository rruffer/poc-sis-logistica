package rest.doc;

import javax.ws.rs.core.Response;

import dto.SolicitacaoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Solicitacao")
public interface SolicitacaoDoc {
	
	@ApiOperation(value = "Receber solicitação")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Solicitação gravada com sucesso!"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") 
			})
	public Response receberSolicitacao(SolicitacaoDTO solicitacaoDTO);

}
