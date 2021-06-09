package Main;

import java.util.Date;

public class Bebida extends Produto {
	private String tipo;
	private String embalagem;
	private double preco;
	private int estoque;
	private Date dataDeValidade;
	
	public Bebida adicionarBebida(String tipo, String embalagem, double preco, int estoque, Date dataDeValidade) {
		Bebida bebida = new Bebida();
		
		bebida.setTipo(tipo);
		bebida.setEmbalagem(embalagem);
		bebida.setPreco(preco);
		bebida.setEstoque(estoque);
		bebida.setDataDeValidade(dataDeValidade);
		
		return bebida;
	}
	
	@Override
	public void listarProdutos() {
		// TODO Auto-generated method stub
		super.listarProdutos();
	}

	@Override
	public void excluirProduto(int ID) {
		// TODO Auto-generated method stub
		super.excluirProduto(ID);
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

}
