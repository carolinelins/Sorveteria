package Main;

import java.sql.Date;

public class Produto {
	private int ID;
	private double preco;
	private int estoque;
	private Date dataDeValidade;
	
	public void listarProdutos() {
		// M�todo a ser desenvolvido posteriormente junto � implementa��o do SGBD.
	}
	
	public void excluirProduto(int ID) {
		// M�todo a ser desenvolvido posteriormente junto � implementa��o do SGBD.
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Date getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(Date dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	};
}