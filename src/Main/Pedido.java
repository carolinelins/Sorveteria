package Main;

import java.util.ArrayList;

public class Pedido {
	private int ID;
	private ArrayList<Produto> produtos;
	private double preco;
	private int clienteID;
	private String formaDePagamento;
	
	public Pedido adicionarPedido(ArrayList<Produto> produtos, Cliente cliente, String formaDePagamento) {
		Pedido pedido = new Pedido();
		
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
		
		return pedido;
	}
	
	public void listarPedidos() {
		
	}
	
	public void excluirPedido(int ID) {
		
	}
}
