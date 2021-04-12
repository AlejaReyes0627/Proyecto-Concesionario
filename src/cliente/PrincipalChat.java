package cliente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class PrincipalChat extends JFrame
{
	private static final long serialVersionUID = 1L;
	public JTextField campoTexto;
    public JTextArea areaTexto;
    private static Socket cliente;
    private static String ip = "127.0.0.1"; 
   
    public static PrincipalChat main;
   
    public PrincipalChat(){
        super("Cliente");
 
        campoTexto = new JTextField();
        campoTexto.setEditable(false); 
        add(campoTexto, BorderLayout.NORTH);
       
       
        areaTexto = new JTextArea(); 
        areaTexto.setEditable(false);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        areaTexto.setForeground(Color.BLACK); 
        campoTexto.setForeground(Color.BLACK); 
       
       
       
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem salir = new JMenuItem("Salir");
        menuArchivo.add(salir); 
       
        JMenuBar barra = new JMenuBar(); 
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
   
    //Para mostrar texto en displayArea
    public void mostrarMensaje(String mensaje) 
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
        ExecutorService executor = Executors.newCachedThreadPool(); //Para correr los threads
 
        try 
        {
            main.mostrarMensaje("Buscando Servidor ...");
            cliente = new Socket(InetAddress.getByName(ip), 11111); 
            main.mostrarMensaje("Conectado a :" +cliente.getInetAddress().getHostName());
   
            main.habilitarTexto(true); 
           
            //Ejecucion de los Threads
            executor.execute(new ThreadRecibe(cliente, main));
            executor.execute(new ThreadEnvia(cliente, main));
           
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(PrincipalChat.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally 
        {
        	
        }
        executor.shutdown();
    }

}
