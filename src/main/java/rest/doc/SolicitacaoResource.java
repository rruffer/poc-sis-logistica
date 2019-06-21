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
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import security.Secured;

@Path("/solicitacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Solicitação", description = "Entrada de solicitações")
@SecurityScheme(name = "authorization",
type = SecuritySchemeType.APIKEY,
in = SecuritySchemeIn.HEADER,
paramName = "authorization",
flows = @OAuthFlows(
        implicit = @OAuthFlow(authorizationUrl = "http://url.com/auth",
                scopes = @OAuthScope(name = "write:pets", description = "modify pets in your account"))))
public interface SolicitacaoResource {

	@GET
	@Operation(summary = "Retorna todas as solicitações", description = "Método retorna uma lista de todas as solicitações")
	public Response obterListaSolicitacao();

	@GET
	@Path("/{id}")
	@Operation(summary = "Retorna uma determidada solicitação", description = "Método retorna uma socilitação pelo ID")
	public Response obterSolicitacao(@PathParam("id") long id);

	@Secured
	@POST
	@Path("/addSolicitacao")
	@Operation(summary = "Adiciona uma solicitação", description = "Método que grava uma solicitação")
    @SecurityRequirement(name = "authorization", scopes = "write: read")
	public Response addSolicitacao(SolicitacaoDTO solicitacaoDTO);

}
