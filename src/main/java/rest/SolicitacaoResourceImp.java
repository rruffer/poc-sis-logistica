package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import dto.SolicitacaoDTO;
import model.Solicitacao;
import rest.doc.SolicitacaoResource;
//import service.SolicitacaoService;
import service.SolicitacaoService;

@Stateless
public class SolicitacaoResourceImp implements SolicitacaoResource {

	@Inject
	private SolicitacaoService solicitacaoService;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public Response obterListaSolicitacao() {
		List<Solicitacao> listaSolicitacao = solicitacaoService.obterListaSolicitacao();
		
		if(listaSolicitacao == null) {
			return Response.status(Status.NO_CONTENT).entity("Solicitação não existe").build();			
		}
		
		List<SolicitacaoDTO> listaSolicitacaoDTO = mapper.map(listaSolicitacao, new TypeToken<List<SolicitacaoDTO>>() {}.getType());
		
		return Response.status(Status.OK).entity(listaSolicitacaoDTO).build();
		
	}
	
	@Override
	public Response obterSolicitacao(long id) {
		Solicitacao solicitacao = solicitacaoService.obterSolicitacaoPorID(id);
		
		if(solicitacao == null) {
			return Response.status(Status.NO_CONTENT).entity("Solicitação não existe").build();			
		}
		
		SolicitacaoDTO solicitacaoDTO = mapper.map(solicitacao, SolicitacaoDTO.class);
		
		return Response.status(Status.OK).entity(solicitacaoDTO).build();
		
	}
	

	@Override
	public Response addSolicitacao(SolicitacaoDTO solicitacaoDTO) {

		Solicitacao solicitacao = null;
		
		try {

			solicitacao  = mapper.map(solicitacaoDTO, Solicitacao.class);
			solicitacao = solicitacaoService.salvarSolicitacao(solicitacao);

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(solicitacao).build();
		}

		return Response.status(Status.OK).entity(solicitacao).build();
	}

}
