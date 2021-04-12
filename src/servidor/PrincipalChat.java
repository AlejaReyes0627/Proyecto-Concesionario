package servidor;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class PrincipalChat extends JFrame
{
	private static final long serialVersionUID = 1L;
	public JTextField campoTexto; //Para mostrar mensajes de los usuarios
	public JTextArea areaTexto; //Para ingresar mensaje a enviar
	private static ServerSocket servidor; //
	private static Socket conexion; 

	public static PrincipalChat main;

	public PrincipalChat()
	{
		super("Servidor"); 

		campoTexto = new JTextField(); 
		campoTexto.setEditable(false); 
		add(campoTexto, BorderLayout.NORTH); 

		areaTexto = new JTextArea();
		areaTexto.setEditable(false);
		add(new JScrollPane(areaTexto), BorderLayout.CENTER);
		areaTexto.setBackground(Color.WHITE); 
		areaTexto.setForeground(Color.BLACK); 
		campoTexto.setForeground(Color.BLACK); 


		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem salir = new JMenuItem("Salir");
		menuArchivo.add(salir); 

		JMenuBar barra = new JMenuBar(); //Crea la barra de menus
		setJMenuBar(barra); //Agrega barra de menus a la aplicacion
		barra.add(menuArchivo); 

		salir.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0); 
			}
		});

		setSize(300, 320); 
		setVisible(true); 
	}


	public void mostrarMensaje(Object mensaje) 
	{
		areaTexto.append(mensaje + "\n");
	}
	public void habilitarTexto(boolean editable)
	{
		campoTexto.setEditable(editable);
	}

	public static void main(String[] args) 
	{
		PrincipalChat main = new PrincipalChat(); 
		main.setLocationRelativeTo(null);  
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		ExecutorService executor = Executors.newCachedThreadPool(); 

		try 
		{
			servidor = new ServerSocket(11111, 100);
			main.mostrarMensaje("Esperando Cliente ...");

			while (true)
			{
				try 
				{
					conexion = servidor.accept(); //Permite al servidor aceptar conexiones        

					main.mostrarMensaje("Conectado a : " +conexion.getInetAddress().getHostName());

					main.habilitarTexto(true);

					//Ejecucion de los threads
					executor.execute(new ThreadRecibe(conexion, main)); 

				} catch (IOException ex) {
					Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE,null, ex);
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
		} //Fin del catch
		finally {
		}
		executor.shutdown();
	}
}

