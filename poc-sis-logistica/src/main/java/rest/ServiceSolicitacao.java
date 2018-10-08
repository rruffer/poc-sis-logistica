package rest;

import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.SolicitacaoDAO;
import dto.SolicitacaoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Cliente;
import model.Solicitacao;

@Stateless
@Path("/solicitacao")
@Api(value = "Solicitacao")
public class ServiceSolicitacao {

	@Inject
	private SolicitacaoDAO dao;

	@POST
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@ApiOperation(value = "Receber solicitação")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Solicitação recebida"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") })
	public Response receberSolicitacao(SolicitacaoDTO solicitacaoDTO) {

		try {

			salvarSolicitacao(solicitacaoDTO);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Response.status(201).entity(solicitacaoDTO).build();
	}
	
	private void salvarSolicitacao(SolicitacaoDTO solicitacaoDTO) throws Exception{
		
		Solicitacao solicitacao = new Solicitacao();
		
		Cliente cliente = new Cliente();
		cliente.setId(solicitacaoDTO.getCliente().getId());
		new Cliente().setId(solicitacaoDTO.getCliente().getId());
		
		solicitacao.setCliente(cliente);
		solicitacao.setDateColeta(solicitacaoDTO.getDateColeta());
		solicitacao.setEndColeta(solicitacaoDTO.getEndColeta());
		solicitacao.setDateEntrega(solicitacaoDTO.getDateEntrega());
		solicitacao.setEndEntrega(solicitacaoDTO.getEndEntrega());
		solicitacao.setDateCadastro(LocalDateTime.now());
		solicitacao.setNatureza(solicitacaoDTO.getNatureza());
		solicitacao.setEspecie(solicitacaoDTO.getEspecie());
		solicitacao.setQuantidade(solicitacaoDTO.getQuantidade());
		solicitacao.setPeso(solicitacaoDTO.getPeso());
		solicitacao.setObservacao(solicitacaoDTO.getObservacao());
//		solicitacao.setDateCadastro(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
		dao.save(solicitacao);
		
	}

}
