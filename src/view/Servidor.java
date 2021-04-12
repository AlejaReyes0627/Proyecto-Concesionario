package view;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Scanner;

import model.container.Entity;
import model.dao.Dto;

public class Servidor 
{
	 private Socket socket;
	    private ServerSocket serverSocket;
	    private DataInputStream bufferDeEntrada = null;
	    private ObjectOutputStream bufferDeSalida = null;
	    Scanner escaner = new Scanner(System.in);
	    final String COMANDO_TERMINACION = "adios";
	    private final int numeroConexiones = 30;

	    public void levantarConexion(int puerto) 
	    {
	        try 
	        {
	            serverSocket = new ServerSocket(puerto, numeroConexiones);
	            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
	            socket = serverSocket.accept();
	            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
	        } 
	        catch (Exception e) 
	        {
	            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
	            System.exit(0);
	        }
	        
	    }
	    public void flujos() 
	    {
	        try 
	        {
	            bufferDeEntrada = new DataInputStream(socket.getInputStream());
	            bufferDeSalida = new ObjectOutputStream(socket.getOutputStream());
	            bufferDeSalida.flush();
	        } 
	        catch (IOException e) 
	        {
	            mostrarTexto("Error en la apertura de flujos");
	        }
	        
	        
	    }

	    public void recibirDatos() 
	    {
	    Object st = "";
	        try 
	        {
	            do 
	            {
	                st = bufferDeEntrada.readUTF();
	                mostrarTexto("\n[Cliente] => " + st);
	                if((st.toString()).contains("select"))
	                {
	                	Dto resp = getData((ResultSet) st);
	                	bufferDeSalida.writeObject(resp);
	                	bufferDeSalida.flush();
	                }
	                System.out.print("\n[Usted] => ");
	            }
	            while (!st.equals(COMANDO_TERMINACION));
	        } 
	        catch (IOException e) 
	        {
	            cerrarConexion();
	        }
	    }


	    public void enviar(String s) 
	    {
	        try 
	        {
	        
	            bufferDeSalida.writeUTF(s);
	            bufferDeSalida.flush();
	        } 
	        catch (IOException e) 
	        {
	            mostrarTexto("Error en enviar(): " + e.getMessage());
	        }
	    }

	    public static void mostrarTexto(String s) 
	    {
	        System.out.print(s);
	    }

	    public void escribirDatos() 
	    {
	        while (true) 
	        {
	            System.out.print("[Usted] => ");
	            enviar(escaner.nextLine());   
	        }
	    }

	    public void cerrarConexion() 
	    {
	        try 
	        {
	            bufferDeEntrada.close();
	            bufferDeSalida.close();
	            socket.close();
	        } 
	        catch (IOException e) 
	        {
	          mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
	        }
	        finally 
	        {
	            mostrarTexto("Conversación finalizada....");
	            System.exit(0);

	        }
	    }

	    public void ejecutarConexion(int puerto) 
	    {
	        Thread hilo = new Thread(new Runnable() 
	        {
	            @Override
	            public void run() 
	            {
	                while (true) 
	                {
	                    try 
	                    {
	                        levantarConexion(puerto);
	                        flujos();
	                        recibirDatos();
	                    } 
	                    finally 
	                    {
	                        cerrarConexion();
	                    }
	                }
	            }
	        });
	        hilo.start();
	    }
	    
	    @SuppressWarnings({ "rawtypes", "unchecked" })
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

	    @SuppressWarnings("resource")
		public static void main(String[] args) throws IOException 
	    {
	        Servidor s = new Servidor();
	        Scanner sc = new Scanner(System.in);

	        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
	        String puerto = sc.nextLine();
	        if (puerto.length() <= 0)
	        	{
	        	puerto = "5050";
	        	}
	        s.ejecutarConexion(Integer.parseInt(puerto));
	        s.escribirDatos();
	    }
	
	
	
	
	
	
}
