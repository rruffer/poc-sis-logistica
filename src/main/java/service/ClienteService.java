package service;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.ClienteDAO;
import model.Cliente;

@Local
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ClienteService {

	@Inject
	private ClienteDAO clienteDAO;
	
	public Cliente salvar(Cliente cliente) throws Exception {
		cliente.setDataCadastro(LocalDateTime.now());
		return clienteDAO.save(cliente);
	}

	public Cliente obterClientePorID(long id) {
		return clienteDAO.find(id);
	}

	public List<Cliente> obterListaClientes() {
		return clienteDAO.findAll();
	}

}
