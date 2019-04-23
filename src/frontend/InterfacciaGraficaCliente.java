package frontend;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import backend.Clients;

public class InterfacciaGraficaCliente extends JFrame implements ActionListener {

	private ArrayList<String> indirizzi;
	private JMenu menu;
	private JMenuItem inserireIndirizzo;
	
	private JTextArea testo;
	
	private Dialogo d ;
	
	private Clients cliente;
	
	private String messaggioRicevuto;

	public String getMessaggioRicevuto() {
		return messaggioRicevuto;
	}
	public void setMessaggioRicevuto(String messaggioRicevuto) {
		this.messaggioRicevuto = messaggioRicevuto;
	}
	public void initComponents()
	{
		indirizzi = new ArrayList<String>();
		menu = new JMenu("Menu");
		inserireIndirizzo = new JMenuItem("Aprire Pagina");
		inserireIndirizzo.addActionListener(this);
		menu.add(inserireIndirizzo);
		JMenuBar barra = new JMenuBar();
		barra.add(menu);
		setJMenuBar(barra);
		testo = new JTextArea();
		add(testo);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(inserireIndirizzo))
		{
			d = new Dialogo(this,"Programma",true);
			//caricaeLetturaPagina(d.getTestotxt().getText());
		}
		
	}
	public Dialogo getD() {
		return d;
	}
	public void setD(Dialogo d) {
		this.d = d;
	}

}
