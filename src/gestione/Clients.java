package gestione;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clients {
	private Socket server=null;
	private static final int port =8080;
	private DataInputStream input;
	private DataOutputStream output;
	
	public Socket connetti()
	{
		try {
			System.out.println("Provo a connettermi ....");
			Socket server = new Socket(InetAddress.getLocalHost(),port);
			
			System.out.println("Connesso");
			input = new DataInputStream(server.getInputStream());
			output=new DataOutputStream(server.getOutputStream());
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Host sconosciuto");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return server;
	}
	public static void main(String[] args)
	{
		Clients c = new Clients();
		c.connetti();
	}
	

}
