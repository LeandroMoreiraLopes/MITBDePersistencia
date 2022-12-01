package br.edu.infnet.pedidos.model.persistance;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.pedidos.model.entity.Entrega;

public class EntregaDAOTest {

	@Before
	public void inicializar() {
		EntregaDAO entregaDAO = new EntregaDAO();
		
		Entrega entrega = new Entrega("Joseph Mariah", "1234");
		entregaDAO.salvar(entrega);
	}
		
	@Test
	public void test() {
		EntregaDAO entregaDAO = new EntregaDAO();
		
		Entrega entrega = new Entrega("Josias", "1111");
		boolean validacao = entregaDAO.salvar(entrega);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListaEntregas() {
		EntregaDAO entregaDAO = new EntregaDAO();
	
		List<Entrega> lista = entregaDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	
	@Test
	public void testAtualizar() {
		EntregaDAO entregaDAO = new EntregaDAO();
		
		Entrega entrega = new Entrega(entregaDAO.listarTodos().get(0).getCodigo(), "Jose", "123", "cancelada");
		boolean validacao = entregaDAO.atualizar(entrega);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testDeletar() {
		EntregaDAO entregaDAO = new EntregaDAO();
		
		Entrega entrega = new Entrega(entregaDAO.listarTodos().get(0).getCodigo(), null, null, null);
		boolean validacao = entregaDAO.deletar(entrega);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListarUm() {
		EntregaDAO entregaDAO = new EntregaDAO();
	
		Entrega cliente = entregaDAO.obter(entregaDAO.listarTodos().get(0).getCodigo());
		Assert.assertNotNull(cliente);
	}
}
