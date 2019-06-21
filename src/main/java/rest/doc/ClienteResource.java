package rest.doc;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.ClienteDTO;
import dto.SolicitacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Clientes", description = "Cadastro e consulta de clientes")
public interface ClienteResource {

	@GET
	@Operation(summary = "Todos os clientes", description = "Método retorna uma lista de clientes")
	public Response obterListaClientes();
	
	@GET
	@Path("/{id}")
	@Operation(summary = "Pesquisar cliente", description = "Método retorna um cliente através do seu ID")
	public Response obterCliente(@PathParam("id") long id);

	@POST
	@Path("/addCliente")
	@Operation(summary = "Aicionar cliente", description = "Método que adiciona um cliente")
	public Response addCliente(ClienteDTO clienteDTO);

}
