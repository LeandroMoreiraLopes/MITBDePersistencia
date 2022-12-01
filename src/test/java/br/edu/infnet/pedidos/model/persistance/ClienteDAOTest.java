package br.edu.infnet.pedidos.model.persistance;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.pedidos.model.entity.Cliente;

public class ClienteDAOTest {

	@Before
	public void inicializar() {
		IDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente("Joseph Mariah");
		clienteDAO.salvar(cliente);
	}
		
	@Test
	public void test() {
		IDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente("Josias");
		boolean validacao = clienteDAO.salvar(cliente);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListaClientes() {
		IDAO clienteDAO = new ClienteDAO();
	
		List<Cliente> lista = clienteDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	
	@Test
	public void testAtualizar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente("Jose", clienteDAO.listarTodos().get(0).getCodigo());
		boolean validacao = clienteDAO.atualizar(cliente);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testDeletar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = new Cliente(null, clienteDAO.listarTodos().get(0).getCodigo());
		boolean validacao = clienteDAO.deletar(cliente);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListarUm() {
		ClienteDAO clienteDAO = new ClienteDAO();
	
		Cliente cliente = clienteDAO.obter(clienteDAO.listarTodos().get(0).getCodigo());
		Assert.assertNotNull(cliente);
	}
}
