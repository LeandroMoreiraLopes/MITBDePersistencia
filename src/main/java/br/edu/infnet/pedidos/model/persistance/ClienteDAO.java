package br.edu.infnet.pedidos.model.persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedidos.model.entity.Cliente;

public class ClienteDAO extends JdbcDAO<Cliente>{

	@Override
	public Boolean salvar(Cliente cliente)
	{
		String sql = "insert into cliente (nome, codigo) values (?, null)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	//Retrieve all
	@Override
	public List<Cliente> listarTodos()
	{
		String sql = "select * from cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next())
			{
				String nome = rs.getString("nome");
				Long codigo = rs.getLong("codigo");
				Cliente cliente = new Cliente(nome, codigo);
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Update
	@Override
	public Boolean atualizar(Cliente cliente)
	{
		String sql = "update cliente set nome = ? where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setLong(2, cliente.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	//Delete
	@Override
	public Boolean deletar(Cliente cliente)
	{
		String sql = "delete from cliente where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, cliente.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	//Retrieve one
	@Override
	public Cliente obter(Long codigo)
	{
		String sql = "select * from cliente where codigo = ?";
		Cliente cliente = new Cliente();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, codigo);
			rs = pstm.executeQuery();
			if (rs.next())
			{
				String nome = rs.getString("nome");
				Long codigoDB = rs.getLong("codigo");
				cliente = new Cliente(nome, codigoDB);
			}
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
