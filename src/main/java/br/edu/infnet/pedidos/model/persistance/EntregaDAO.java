package br.edu.infnet.pedidos.model.persistance;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedidos.model.entity.Entrega;

public class EntregaDAO extends JdbcDAO<Entrega>{

	@Override
	public Boolean salvar(Entrega obj) {
		String sql = "insert into entrega (codigo, entregador, codigoconfirmacao, status) values (null, ?, ?, ?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getEntregador());
			pstm.setString(1, obj.getCodigoConfirmacao());
			pstm.setString(1, obj.getStatus());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public List<Entrega> listarTodos() {
		String sql = "select * from entrega";
		List<Entrega> entregas = new ArrayList<Entrega>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next())
			{
				Long codigo = rs.getLong("codigo");
				String entregador = rs.getString("entregador");
				String codigoConfirmacao = rs.getString("codigoconfirmacao");
				String status = rs.getString("status");
				Entrega entrega = new Entrega(codigo, entregador, codigoConfirmacao, status);
				entregas.add(entrega);
			}
			return entregas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Boolean atualizar(Entrega obj) {
		String sql = "update entrega set entregador = ?, codigoconfirmacao = ?, status = ? where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getEntregador());
			pstm.setString(2, obj.getCodigoConfirmacao());
			pstm.setString(3, obj.getStatus());
			pstm.setLong(4, obj.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public Boolean deletar(Entrega obj) {
		String sql = "delete from entrega where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, obj.getCodigo());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public Entrega obter(Long codigo) {
		String sql = "select * from entrega where codigo = ?";
		Entrega entrega = new Entrega();
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, codigo);
			rs = pstm.executeQuery();
			if (rs.next())
			{
				Long codigoDB = rs.getLong("codigo");
				String entregador = rs.getString("entregador");
				String codigoConfirmacao = rs.getString("codigoconfirmacao");
				String status = rs.getString("status");
				entrega = new Entrega(codigoDB, entregador, codigoConfirmacao, status);
			}
			return entrega;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
