package backend;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import frontend.InterfacciaGraficaCliente;
import server.backend.service.serverService.ByteServerServiceFactory;

public class Clients implements Runnable {
	private Socket server=null;
	private static final int port =8080;
	private DataInputStream input;
	private DataOutputStream output;
	
	private InterfacciaGraficaCliente i;
	
	public InterfacciaGraficaCliente getI() {
		return i;
	}
	public void setI(InterfacciaGraficaCliente i) {
		this.i = i;
	}
	
	public Clients() {
		super();
		i= new InterfacciaGraficaCliente();
		
	}
	public void comunica()
	{
		//messaggio da inviare al server cioe l url
		if(i.getD().getTestotxt()!=null)
		{
			System.out.println("ciao");
			String messaggio = i.getD().getTestotxt().getText();
			try {
				//invio convertire in byteeee
				output.writeBytes(messaggio);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] ris=ByteServerServiceFactory.getByteServerService().leggiByteIngresso(server);
			char[] chars = new char[ris.length];
			for(int i = 0; i < ris.length; i++) {
				chars[i] = (char) ris[i];
			}
			
			//File file = null;
			String indirizzo = String.valueOf(chars);
			i.getTesto().setText(indirizzo);
			
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
		while(c.getI().getD()==null)
		{
			System.out.println("mm");
		}
		if(c.getI().getD().getTestotxt().getText()!=null)
		{
			System.out.println("ciao");
			c.comunica();
		}	
		
		
	}
	@Override
	public void run() {
		while(true) {
			
		
		}
		
	}
	

}
