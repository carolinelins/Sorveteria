package Main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import ConexaoBanco.ConexaoMySQL;

public class Pedido {
	private int ID;
	private ArrayList<Produto> produtos;
	private double preco;
	private int clienteID;
	private String formaDePagamento;
	
	public Pedido adicionarPedido(ArrayList<Produto> produtos, Cliente cliente, String formaDePagamento) {
		Connection con = ConexaoMySQL.getConexao();
		Pedido p = new Pedido();
		PedidoDAO pd = new PedidoDAO(con);
		p.setPreco(preco);
		p.setClienteID(cliente.getID());
		p.setFormaDePagamento(formaDePagamento);
		
		System.out.println(pd.inserir(p));
		
		ConexaoMySQL.fecharConexao(con);
		
		return p;
		
		/*Pedido pedido = new Pedido();
		
		produtos.forEach(produto -> {
			if (produto.getEstoque() == 0) {
				return;
			}
			this.produtos.add(produto);
			this.preco += produto.getPreco();
			produto.setEstoque(produto.getEstoque() - 1);
		});
		
		this.clienteID = cliente.getID();
		if (cliente.getPedidos().size() % 5 == 0) {
			this.preco *= 0.9;
		}
		this.formaDePagamento = formaDePagamento;
		
		return pedido;*/
	}
	
	public void listarPedidos() {
		Connection con = ConexaoMySQL.getConexao();
		PedidoDAO pd = new PedidoDAO(con);
		List<Pedido> lista = pd.listarTodos();
		if(lista != null){
			for(Pedido pedido : lista){
				System.out.println("Preço: "+pedido.getPreco());
				System.out.println("Cliente: "+pedido.getClienteID());
				System.out.println("Forma de Pagamento: "+pedido.getFormaDePagamento());
			}
		}
		ConexaoMySQL.fecharConexao(con);
	}
	
	public void excluirPedido(int ID) {
		Connection con = ConexaoMySQL.getConexao();
		Pedido p = new Pedido();
		PedidoDAO pd = new PedidoDAO(con);
		//Testando método inserir
		p.setID(ID);
		System.out.println(pd.excluir(p));
		
		ConexaoMySQL.fecharConexao(con);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getClienteID() {
		return clienteID;
	}

	public void setClienteID(int clienteID) {
		this.clienteID = clienteID;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	
}
