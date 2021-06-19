package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import Main.BebidaDAO;
import Main.Cliente;
import Main.ClienteDAO;
import Main.Connectionz;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class listaAll extends JFrame {

	private JPanel contentPane;
	private JTable tablePesq;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listaAll frame = new listaAll();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public listaAll() {
		setTitle("PESQUISAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tablePesq = new JTable();
		tablePesq.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton btnListar = new JButton("Search");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pesquisarAll();
			}
			
		});
		
		JRadioButton rdbtnClientePesq = new JRadioButton("Cliente");
		buttonGroup.add(rdbtnClientePesq);
		JRadioButton rdbtnPedidoPesq = new JRadioButton("Pedido");
		buttonGroup.add(rdbtnPedidoPesq);
		JRadioButton rdbtnSorvetePesq = new JRadioButton("Sorvete");
		buttonGroup.add(rdbtnSorvetePesq);
		JRadioButton rdbtnBebidaPesq = new JRadioButton("Bebida");
		buttonGroup.add(rdbtnBebidaPesq);
		
		rdbtnPedidoPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPedidoPesq.isSelected()) {
					rdbtnClientePesq.setSelected(false);
					rdbtnSorvetePesq.setSelected(false);
					rdbtnBebidaPesq.setSelected(false);
					
				}
			}
		});
		
		rdbtnBebidaPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnBebidaPesq.isSelected()) {
					rdbtnClientePesq.setSelected(false);
					rdbtnSorvetePesq.setSelected(false);
					rdbtnPedidoPesq.setSelected(false);
					
				}
			}
		});
		
		rdbtnSorvetePesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSorvetePesq.isSelected()) {
					rdbtnClientePesq.setSelected(false);
					rdbtnBebidaPesq.setSelected(false);
					rdbtnPedidoPesq.setSelected(false);
					
				}
			}
		});
		
		rdbtnClientePesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnClientePesq.isSelected()) {
					rdbtnSorvetePesq.setSelected(false);
					rdbtnBebidaPesq.setSelected(false);
					rdbtnPedidoPesq.setSelected(false);
					
				}
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnClientePesq)
									.addGap(66)
									.addComponent(rdbtnSorvetePesq))
								.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnBebidaPesq)
									.addGap(70)
									.addComponent(rdbtnPedidoPesq))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(53))))
						.addComponent(tablePesq, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPedidoPesq)
						.addComponent(rdbtnClientePesq)
						.addComponent(rdbtnSorvetePesq)
						.addComponent(rdbtnBebidaPesq))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(tablePesq, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void pesquisarAll() {
		JRadioButton rdbtnClientePesq = new JRadioButton("Cliente");
		
		JRadioButton rdbtnSorvetePesq = new JRadioButton("Sorvete");
		
		JRadioButton rdbtnBebidaPesq = new JRadioButton("Bebida");
		
		JRadioButton rdbtnPedidoPesq = new JRadioButton("Pedido");
		/*rdbtnClientePesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnClientePesq.isSelected()) {
					rdbtnSorvetePesq.setSelected(false);
					rdbtnBebidaPesq.setSelected(false);
					rdbtnPedidoPesq.setSelected(false);
					
				}
			}
		});*/
		try {
			if(rdbtnClientePesq.isSelected()) {
				
			}
			ClienteDAO objClienteDAO = new ClienteDAO(null);
			
			DefaultTableModel model = (DefaultTableModel) tablePesq.getModel();
			model.setNumRows(0);
			ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) objClienteDAO.listarTodos();

			
			for(int num = 0; num < listaCliente.size(); num++) {
				model.addRow(new Object[] {
					listaCliente.get(num).getID(),
					listaCliente.get(num).getNome(),
					listaCliente.get(num).getCPF(),
					
					
				});
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Pesquisar Objetos: " + erro);
		}
	}
}
