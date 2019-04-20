package backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import frontend.InterfacciaGraficaCliente;

public class Clients {
	private Socket server=null;
	private static final int port =8080;
	private DataInputStream input;
	private DataOutputStream output;
	
	private InterfacciaGraficaCliente i;
	
	public void comunica()
	{
		//messaggio da inviare al server cioe l url
		String messaggio = i.getD().getTestotxt().getText();
		try {
			//invio convertire in byteeee
			output.writeBytes(messaggio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//server genera la pagina e mi restitusce la roba(gia convertita oppure solo la pagina come vuoi tu :)
		try {
			
			String ricevuta =input.readLine();
			i.setMessaggioRicevuto(ricevuta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
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
		c.comunica();
	}
	

}
