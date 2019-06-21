package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import dto.ClienteDTO;
import model.Cliente;
import rest.doc.ClienteResource;
import service.ClienteService;

@Stateless
public class ClienteResourceImp implements ClienteResource {

	@Inject
	private ClienteService clienteService;
	
	private ModelMapper mapper = new ModelMapper();


	@Override
	public Response obterListaClientes() {
		List<Cliente> listaClientes = clienteService.obterListaClientes();
		
		if(listaClientes == null) {
			return Response.status(Status.NO_CONTENT).entity("Solicitação não existe").build();			
		}
		
		List<ClienteDTO> listaClienteDTO = mapper.map(listaClientes, new TypeToken<List<ClienteDTO>>() {}.getType());
		
		return Response.status(Status.OK).entity(listaClienteDTO).build();
	}

	@Override
	public Response obterCliente(long id) {
		Cliente cliente = clienteService.obterClientePorID(id);
		
		if(cliente == null) {
			return Response.status(Status.NO_CONTENT).entity("Cliente não existe").build();			
		}
		
		ClienteDTO clienteDTO = mapper.map(cliente, ClienteDTO.class);
		
		return Response.status(Status.OK).entity(clienteDTO).build();
	}

	@Override
	public Response addCliente(ClienteDTO clienteDTO) {
		Cliente cliente = null;
		
		try {

			cliente  = mapper.map(clienteDTO, Cliente.class);
			cliente = clienteService.salvar(cliente);

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(cliente).build();
		}

		return Response.status(Status.OK).entity(cliente).build();
	}

}
