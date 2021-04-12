package design;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Server {

	private JFrame server;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.server.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		server = new JFrame();
		server.setTitle("Servidor");
		server.setBounds(100, 100, 847, 377);
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 155, 603, 176);
		server.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Placa", "Marca", "Modelo", "Linea", "Color", "Tipo vehiculo", "Precio", "Propietario"
			}
		));
		table.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Actualizar lista");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(653, 286, 172, 23);
		server.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Agregar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(653, 23, 172, 23);
		server.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(653, 90, 172, 23);
		server.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(653, 155, 172, 23);
		server.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Mensajes clientes");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(653, 220, 172, 23);
		server.getContentPane().add(btnNewButton_4);
	
		
		JLabel lblCentroDeControl = new JLabel("Centro de control");
		lblCentroDeControl.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblCentroDeControl.setBounds(10, 32, 271, 37);
		server.getContentPane().add(lblCentroDeControl);
	}

}
