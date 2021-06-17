package Main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BebidaDAO {

	private Connection con;

	public BebidaDAO(Connection con) {

		setCon(con);

	}

	public String inserir(Bebida bebida) {

		String sql = "insert into bebida(tipo,embalagem,preco,estoque,data_de_validade)values(?,?,?,?,?)";

		try {

			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, bebida.getTipo());
			ps.setString(2, bebida.getEmbalagem());
			ps.setDouble(3, bebida.getPreco());
			ps.setInt(4, bebida.getEstoque());
			ps.setDate(5, (Date) bebida.getDataDeValidade());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir";
			}

		} catch (SQLException e) {

			return e.getMessage();

		}

	}

	public String excluir(Bebida bebida) {

		String sql = "delete from bebida where id = ?";

		try {

			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setInt(1, bebida.getID());

			if (ps.executeUpdate() > 0) {

				return "Excluído com sucesso.";

			} else {

				return "Erro ao excluir";

			}

		} catch (SQLException e) {

			return e.getMessage();

		}

	}

	public List<Bebida> listarTodos() {

		String sql = "select * from bebida ";
		
		List<Bebida> listaBebida = new ArrayList<Bebida>();
		
		try {
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				
				while (rs.next()) {
					
					Bebida b = new Bebida();
					b.setTipo(rs.getString(1));
					b.setEmbalagem(rs.getString(2));
					b.setPreco(rs.getDouble(3));
					b.setEstoque(rs.getInt(4));
					b.setDataDeValidade(rs.getDate(5));
					listaBebida.add(b);
					
				}
				
				return listaBebida;
				
			} else {
				
				return null;
			}
			
		} catch (SQLException e) {
			
			return null;
			
		}
		
	}


	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
}
