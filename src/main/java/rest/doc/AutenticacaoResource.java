package rest.doc;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/autenticacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Autenticação", description = "Solicitação  de tokens de autenticação")
public interface AutenticacaoResource {

	@GET
	@Path("/{usuario}/{senha}")
	@Operation(summary = "Obter Token", description = "Método retorna um token para acesso a determinados métodos da API")
	public Response obterToken(@PathParam("usuario") String usuario, @PathParam("senha") String senha);
	
}
