package servidor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.container.Entity;
import model.dao.Dto;
 

public class ThreadRecibe implements Runnable 
{

	private final PrincipalChat main;
    private String mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;
    private ObjectOutputStream salida;

   
   
   public ThreadRecibe(Socket cliente, PrincipalChat main)
   {
       this.cliente = cliente;
       this.main = main;
       
       main.campoTexto.addActionListener(new ActionListener() 
       {
           public void actionPerformed(ActionEvent event) 
           {
               mensaje = event.getActionCommand();
               
               enviarDatos(mensaje); 
               main.campoTexto.setText(""); 
           } 
       });
   }  
 
    public void mostrarMensaje(Object mensaje) 
    {
        main.areaTexto.append((String) mensaje);
    }
   
    public void run() 
    {
        try 
        {
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
            salida.flush();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        do 
        { 
            try 
            {
                mensaje = (String) entrada.readObject(); 
                main.mostrarMensaje(mensaje);
                
                
            } 
            catch (SocketException ex) 
            {
            	
            }
            catch (EOFException eofException) 
            {
                main.mostrarMensaje("Fin de la conexion");
                break;
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (ClassNotFoundException classNotFoundException) 
            {
                main.mostrarMensaje("Objeto desconocido");
            }              
 
        } while (!mensaje.equals("TERMINA")); 
 
        try 
        {
            entrada.close(); 
            cliente.close(); 
            salida.close();
        } 
        catch (IOException ioException) 
        {
            ioException.printStackTrace();
        } 
 
        main.mostrarMensaje("Fin de la conexion");
        System.exit(0);
    }
    
    private void enviarDatos(String mensaje)
    {
       try 
       {
          salida.writeObject("[Servidor] " + mensaje);
          salida.flush(); 
          main.mostrarMensaje("[Servidor] " + mensaje);
       } 
       catch (IOException ioException)
       {
          main.mostrarMensaje("Error escribiendo Mensaje");
       }  
      
    } 
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public Dto getData(ResultSet st)
    {
    	  String nameIDto = "";
          Dto result = null;
          try
          {
			Class classIDto = Class.forName(nameIDto);
              Entity<Dto> executeSql = new Entity<Dto>(classIDto);
              result = executeSql.getSingleRow(st);
          }
          catch (ClassNotFoundException e)
          {
              e.printStackTrace();
          }
          return result;
    	
    }
  
}






