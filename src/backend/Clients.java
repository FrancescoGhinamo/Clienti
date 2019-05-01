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
	private static final int port =80;
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
		if(i.getD().getTestotxt().getText()!=null)
		{
			
			String messaggio = i.getD().getTestotxt().getText();
			//System.out.println(messaggio);
			
			String me =messaggio.substring(9);
			System.out.println(me);
			try {
				//invio convertire in byteeee
				output.writeBytes(me);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] ris=ByteServerServiceFactory.getByteServerService().leggiByteIngresso(server);
			/*char[] chars = new char[ris.length];
			for(int i = 0; i < ris.length; i++) {
				chars[i] = (char) ris[i];
			}

			*/
			String indirizzo = new String(ris);
			i.getTesto().setText(indirizzo);

		}


	}
	public Socket connetti()
	{
		try {
			System.out.println("Provo a connettermi ....");
			//System.out.println(i.getMessaggioRicevuto());
			String giusto=i.getMessaggioRicevuto().substring(i.getMessaggioRicevuto().indexOf(""),i.getMessaggioRicevuto().indexOf("/"));
			
			Socket server = new Socket(giusto,port);
			
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
		Thread t = new Thread(c);
		t.start();



	}
	@Override
	public void run() {
		

		while(true) {

			if(this.getI() != null) {

//				if(this.getI().getD() != null) {
					
					if(this.getI().getMessaggioRicevuto()!="")
					{
						this.connetti();
						
						this.comunica();
					}	
//				}
				
				
			}


		}


	}


}
