package view;
import java.io.*;
import java.net.*;

public class Client 
{
	public static void main(String[] args) {
try
{
	Socket s = new Socket("168.1.6",1201);
	DataInputStream din = new DataInputStream(s.getInputStream());
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	@SuppressWarnings("unused")
	PrintWriter out = new PrintWriter(s.getOutputStream());
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String msgin = "";
	String msgout ="";
	
	while(!msgin.equalsIgnoreCase("End"))
	{
		msgout = br.readLine();
		dout.writeUTF(msgout);
		msgin = din.readUTF();
		System.out.println(msgin);
	}
	s.close();
}catch(Exception e)
{
	
}
	}
}
