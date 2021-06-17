package Main;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import ConexaoBanco.ConexaoMySQL;

public class Bebida extends Produto {
	private int ID;
	private String tipo;
	private String embalagem;
	private double preco;
	private int estoque;
	private Date dataDeValidade;
	
	public Bebida adicionarBebida(String tipo, String embalagem, double preco, int estoque, Date dataDeValidade) {
		Connection con = ConexaoMySQL.getConexao();
		Bebida b = new Bebida();
		BebidaDAO bd = new BebidaDAO(con);

		b.setTipo(tipo);
		b.setEmbalagem(embalagem);
		b.setPreco(preco);
		b.setEstoque(estoque);
		b.setDataDeValidade(dataDeValidade);
		System.out.println(bd.inserir(b));
		
		ConexaoMySQL.fecharConexao(con);
		
		return b;
		
		/*Bebida bebida = new Bebida();
		
		bebida.setTipo(tipo);
		bebida.setEmbalagem(embalagem);
		bebida.setPreco(preco);
		bebida.setEstoque(estoque);
		bebida.setDataDeValidade(dataDeValidade);
		
		return bebida;*/
		
	}
	
	@Override
	public void listarProdutos() {
		Connection con = ConexaoMySQL.getConexao();
		BebidaDAO bd = new BebidaDAO(con);
		List<Bebida> lista = bd.listarTodos();
		if(lista != null){
			for(Bebida bebida : lista){
				System.out.println("Tipo: "+bebida.getTipo());
				System.out.println("Embalagem: "+bebida.getEmbalagem());
				System.out.println("Preço: "+bebida.getPreco());
				System.out.println("Estoque: "+bebida.getEstoque());
				System.out.println("Data de Validade: "+bebida.getDataDeValidade());
			}
		}
		ConexaoMySQL.fecharConexao(con);
	}

	@Override
	public void excluirProduto(int ID) {
		Connection con = ConexaoMySQL.getConexao();
		Bebida b = new Bebida();
		BebidaDAO bd = new BebidaDAO(con);
		//Testando método inserir
		b.setID(ID);
		System.out.println(bd.excluir(b));
		
		ConexaoMySQL.fecharConexao(con);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	@Override
	public double getPreco() {
		// TODO Auto-generated method stub
		return super.getPreco();
	}

	@Override
	public void setPreco(double preco) {
		// TODO Auto-generated method stub
		super.setPreco(preco);
	}

	@Override
	public int getEstoque() {
		// TODO Auto-generated method stub
		return super.getEstoque();
	}

	@Override
	public void setEstoque(int estoque) {
		// TODO Auto-generated method stub
		super.setEstoque(estoque);
	}

	@Override
	public Date getDataDeValidade() {
		// TODO Auto-generated method stub
		return super.getDataDeValidade();
	}

	@Override
	public void setDataDeValidade(Date dataDeValidade) {
		// TODO Auto-generated method stub
		super.setDataDeValidade(dataDeValidade);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
