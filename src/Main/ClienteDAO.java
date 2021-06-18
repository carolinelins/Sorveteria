package Main;

import java.sql.*;
import java.util.*;


public class ClienteDAO {     
	private Connection con;     
	public ClienteDAO(Connection con) {         
		setCon(con);     
	}

	public String inserir(Cliente cliente) {         
		String sql = "insert into cliente(ID,nome,CPF)values(?,?,?)";         
		try {             
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, cliente.getID());             
			ps.setString(2, cliente.getNome());             
			ps.setString(3, cliente.getCPF());             
			if (ps.executeUpdate() > 0) {                 
				return "Inserido com sucesso.";             
			} else {                 
				return "Erro ao inserir";             
			}         } catch (SQLException e) {             
				return e.getMessage();         
			}     
	}


	public String excluir(Cliente cliente) {         
		String sql = "delete from cliente where nome = ?";         
		try {             
			PreparedStatement ps = getCon().prepareStatement(sql);             
			ps.setString(1, cliente.getNome());             
			if (ps.executeUpdate() > 0) {                 
				return "Excluído com sucesso.";             
			} else {                 
				return "Erro ao excluir";             
			}         
		} catch (SQLException e) {             
			return e.getMessage();         
		}   

	}

	public List<Cliente> listarTodos() {         
		String sql = "select * from cliente ";         
		List<Cliente> listaCliente = new ArrayList<Cliente>();         
		try {             
			PreparedStatement ps = getCon().prepareStatement(sql);             
			ResultSet rs = ps.executeQuery();
			if (rs != null) {                 
				while (rs.next()) {                     
					Cliente cb = new Cliente();                    
					cb.setID(rs.getInt(1));                     
					cb.setNome(rs.getString(2));                     
					cb.setCPF(rs.getString(3));                     
					listaCliente.add(cb);                 
				}                 
				return listaCliente;             
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
