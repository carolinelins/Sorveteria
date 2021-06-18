package Main;

import java.sql.*; 
import java.util.*;

import ConexaoBanco.ConexaoMySQL; 
public class TesteClass {     
	public static void main(String[] args) {         
		Connection con = ConexaoMySQL.getConexao();         
		Bebida b = new Bebida();         
		BebidaDAO bd = new BebidaDAO(con);      
		Sorvete s = new Sorvete();         
		SorveteDAO sd = new SorveteDAO(con);
		Pedido p = new Pedido();         
		PedidoDAO pd = new PedidoDAO(con);
		Cliente cb = new Cliente();         
		ClienteDAO cd = new ClienteDAO(con);
			//b.setTipo("Refrigerante");  ---------- ok       
			//b.setPreco(6.99);         
			  //System.out.println(bd.inserir(b));
			  
			  /*s.setID(999); ----------- ok
			  s.setSabor("coco");
			  s.setPreco(6.85);
			  s.setEstoque(50);
			  s.getDataDeValidade();
			  System.out.println(sd.inserir(s));*/
		
		//Testando excluir        -------------- ok
		//b.setID(12473);        
		//System.out.println(bd.excluir(b));
		
		List<Bebida> listaBebida = bd.listarTodos();        
		if(listaBebida != null){             
			for(Bebida bebida : listaBebida){  
				System.out.println("Lista Bebida:");
				System.out.println("ID: "+bebida.getID());                 
				System.out.println("tipo: "+bebida.getTipo());                 
				System.out.println("embalagem: "+bebida.getEmbalagem());
				System.out.println("preco: "+bebida.getPreco()); 
				System.out.println("estoque: "+bebida.getEstoque()); 
				System.out.println("data_de_validade: "+bebida.getDataDeValidade()); 	
				System.out.println("");
			}         
		}     
		List<Cliente> lista = cd.listarTodos();         
		if(lista != null){             
			for(Cliente cliente : lista){ 
				System.out.println("Lista Cliente:");
				System.out.println("ID: "+cliente.getID());                 
				System.out.println("nome: "+cliente.getNome());                 
				System.out.println("CPF: "+cliente.getCPF());  
				System.out.println("");
				}         
			}    
		List<Sorvete> listaSorvete = sd.listarTodos();         
		if(listaSorvete != null){             
			for(Sorvete sorvete : listaSorvete){   
				System.out.println("Lista Sorvete:");
				System.out.println("ID: "+sorvete.getID());                 
				System.out.println("sabor: "+sorvete.getSabor());                 
				System.out.println("preco: "+sorvete.getPreco());
				System.out.println("estoque: "+sorvete.getEstoque()); 
				System.out.println("data_de_validade: "+sorvete.getDataDeValidade()); 
				System.out.println("");
			}         
		}    
		List<Pedido> listaPedido = pd.listarTodos();         
		if(listaPedido != null){             
			for(Pedido pedido : listaPedido){     
				System.out.println("Lista Pedido:");
				System.out.println("preco: "+pedido.getPreco());                 
				System.out.println("cliente_id: "+pedido.getClienteID());                 
				System.out.println("forma_de_pagamento: "+pedido.getFormaDePagamento());
				System.out.println("");
			}         
		} 
			Connectionz.fecharConexao(con);	
	} 
	
}
		
	 
	
		
		
	 
	
			
		
	
		
	



