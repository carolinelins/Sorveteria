package Main;

import java.util.ArrayList;

public class Cliente {
	private int ID;
	private String nome;
	private String CPF;
	private ArrayList<Pedido> pedidos;
	
	public Cliente adicionarCliente(String nome, String CPF) {
		Cliente cliente = new Cliente();
		
		cliente.setNome(nome);
		cliente.setCPF(CPF);
		
		return cliente;
	}
	
	public void listarClientes() {
		
	}
	
	public void excluirCliente(int ID) {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
}
