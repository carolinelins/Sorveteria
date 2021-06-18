package Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

	private Connection con;     
	public PedidoDAO(Connection con) {         
		setCon(con);     
	}

	public String inserir(Pedido pedido) {         
		String sql = "insert into cliente(preco,clienteID,formaDePagamento)values(?,?,?)";         
		try {             
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setDouble(1, pedido.getPreco());             
			ps.setInt(2, pedido.getClienteID());             
			ps.setString(3, pedido.getFormaDePagamento());             
			if (ps.executeUpdate() > 0) {                 
				return "Inserido com sucesso.";             
			} else {                 
				return "Erro ao inserir";             
			}
		} catch (SQLException e) {             
			return e.getMessage();         
		}     
	}


	public String excluir(Pedido pedido) {         
		String sql = "delete from pedido where id = ?";         
		try {             
			PreparedStatement ps = getCon().prepareStatement(sql);             
			ps.setInt(1, pedido.getID());             
			if (ps.executeUpdate() > 0) {                 
				return "Excluído com sucesso.";             
			} else {                 
				return "Erro ao excluir";             
			}         
		} catch (SQLException e) {             
			return e.getMessage();         
		}   

	}

	public List<Pedido> listarTodos() {         
		String sql = "select * from pedido ";         
		List<Pedido> listaPedido = new ArrayList<Pedido>();         
		try {             
			PreparedStatement ps = getCon().prepareStatement(sql);             
			ResultSet rs = ps.executeQuery();
			if (rs != null) {                 
				while (rs.next()) {                     
					Pedido p = new Pedido();                    
					p.setPreco(rs.getDouble(1));                     
					p.setClienteID(rs.getInt(2));                     
					p.setFormaDePagamento(rs.getString(3));                     
					listaPedido.add(p);                 
				}                 
				return listaPedido;             
			} else {                 
				return null;             
			}         
		} catch (SQLException e) {             
			return null;         
		}     
	}     public Connection getCon() {         
		return con;     
	}     
	public void setCon(Connection con) {         
		this.con = con;     
	} 

}

