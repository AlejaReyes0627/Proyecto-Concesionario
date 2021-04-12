import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;

public class ClienteI {

	private JFrame cliente;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteI window = new ClienteI();
					window.cliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClienteI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cliente = new JFrame();
		cliente.setTitle("Cliente");
		cliente.setBounds(100, 100, 635, 377);
		cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cliente.getContentPane().setLayout(null);
		
		JButton btnBuscarMarca = new JButton("Nuestras marcas");
		btnBuscarMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarMarca.setBounds(10, 11, 155, 35);
		cliente.getContentPane().add(btnBuscarMarca);
		
		JButton btnContacto = new JButton("Contactanos");
		btnContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContacto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnContacto.setBounds(185, 11, 142, 35);
		cliente.getContentPane().add(btnContacto);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 603, 140);
		cliente.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Placa", "Marca", "Modelo", "Linea", "Color", "Tipo vehiculo", "Precio", "Propietario"
			}
		));
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 603, 2);
		cliente.getContentPane().add(separator);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(438, 70, 155, 110);
		cliente.getContentPane().add(lblImagen);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(20, 73, 163, 47);
		cliente.getContentPane().add(lblNewLabel_1);
	}
}
