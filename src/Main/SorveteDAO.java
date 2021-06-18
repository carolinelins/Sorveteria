package Main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SorveteDAO {

	private Connection con;

	public SorveteDAO(Connection con) {

		setCon(con);

	}

	public String inserir(Sorvete sorvete) {

		String sql = "insert into sorvete(id,sabor,preco,estoque,data_de_validade)values(?,?,?,?,?)";

		try {

			PreparedStatement ps = getCon().prepareStatement(sql);
			
			ps.setInt(1, sorvete.getID());
			ps.setDouble(2, sorvete.getPreco());
			ps.setString(3, sorvete.getSabor());
			ps.setInt(4, sorvete.getEstoque());
			ps.setDate(5, (Date) sorvete.getDataDeValidade());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso.";
			} else {
				return "Erro ao inserir";
			}

		} catch (SQLException e) {

			return e.getMessage();

		}

	}

	public String excluir(Sorvete sorvete) {

		String sql = "delete from sorvete where preco = ?";

		try {

			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setDouble(2, sorvete.getPreco());

			if (ps.executeUpdate() > 0) {

				return "Excluído com sucesso.";

			} else {

				return "Erro ao excluir";

			}

		} catch (SQLException e) {

			return e.getMessage();

		}

	}

	public List<Sorvete> listarTodos() {

		String sql = "select * from sorvete ";
		
		List<Sorvete> listaSorvete = new ArrayList<Sorvete>();
		
		try {
			
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				
				while (rs.next()) {
					
					Sorvete s = new Sorvete();
					s.setID(rs.getInt(1));
					s.setSabor(rs.getString(2));
					s.setPreco(rs.getDouble(3));
					s.setEstoque(rs.getInt(4));
					s.setDataDeValidade(rs.getDate(5));
					listaSorvete.add(s);
					
				}
				
				return listaSorvete;
				
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
