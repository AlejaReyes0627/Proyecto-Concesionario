package view;
import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Serv 
{	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		try
		{
			 Serv serv = new Serv();
		       Scanner sc = new Scanner(System.in);
			ServerSocket ss = new ServerSocket(1201);
			Socket s = ss.accept();
			
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msgin = "";
			String msgout="";
			
			
			while(!msgin.equalsIgnoreCase("End"))
			{
				msgin = din.readUTF();
				System.out.println(msgin);
				msgout = br.readLine();
				dout.writeUTF(msgout);
				dout.flush();
			}
			s.close();
			ss.close();
		}
		catch(Exception e)
		{
			
		}
		
	}
}
