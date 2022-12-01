package br.edu.infnet.pedidos.model.persistance;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.pedidos.model.entity.Cliente;
import br.edu.infnet.pedidos.model.entity.Pedido;

public class PedidoDAOTest {

	@Test
	public void testListaClientes() {
		IDAO pedidoDAO = new PedidoDAO();
	
		List<Pedido> lista = pedidoDAO.listarTodos();
		System.out.println(lista);
		Assert.assertTrue(lista.size() > 0);
	}
}
