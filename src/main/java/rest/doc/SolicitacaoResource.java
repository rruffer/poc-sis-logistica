package rest.doc;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.SolicitacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.TipoEsquema;
import security.Secured;

@Path("/solicitacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Solicitação", description = "Entrada de solicitações")
//@SecurityScheme(name = "authorization", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER, paramName = "authorization")
@SecurityRequirement(name = "autSolicitacao")
@Secured(esquema = TipoEsquema.SOLICITACAO)
public interface SolicitacaoResource {

	@GET
	@Operation(summary = "Retorna todas as solicitações", description = "Método retorna uma lista de todas as solicitações")
	public Response obterListaSolicitacao();

	@GET
	@Path("/{id}")
	@Operation(summary = "Retorna uma determidada solicitação", description = "Método retorna uma socilitação pelo ID")
	public Response obterSolicitacao(@PathParam("id") long id);

	@POST
	@Path("/addSolicitacao")
	@Operation(summary = "Adiciona uma solicitação", description = "Método que grava uma solicitação")
	public Response addSolicitacao(SolicitacaoDTO solicitacaoDTO);

}
