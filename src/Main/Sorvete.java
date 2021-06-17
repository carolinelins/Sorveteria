package Main;

import java.sql.Date;

public class Sorvete extends Produto {
	private int ID;
	private String sabor;
	private double preco;
	private int estoque;
	private Date dataDeValidade;
	
	public Sorvete adicionarSorvete(String sabor, double preco, int estoque, Date dataDeValidade) {
		Sorvete sorvete = new Sorvete();
		
		sorvete.setSabor(sabor);
		sorvete.setPreco(preco);
		sorvete.setEstoque(estoque);
		sorvete.setDataDeValidade(dataDeValidade);
		
		return sorvete;
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
	
	public void adicionarCasquinha(double preco) {
		setPreco(this.preco * 0.5);
	}


	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
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
