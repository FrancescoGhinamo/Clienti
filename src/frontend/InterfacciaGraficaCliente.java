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

	private JMenu menu;
	private JMenuItem inserireIndirizzo;
	
	private JTextArea testo;
	
	private Dialogo d ;
	
	private volatile String messaggioRicevuto;

	public String getMessaggioRicevuto() {
		return messaggioRicevuto;
	}
	public void setMessaggioRicevuto(String messaggioRicevuto) {
		this.messaggioRicevuto = messaggioRicevuto;
	}
	public InterfacciaGraficaCliente()
	{
		setExtendedState(MAXIMIZED_BOTH);
		initComponents();
		messaggioRicevuto = "";
		setVisible(true);
		
	}
	public void initComponents()
	{
		
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
		
		if(e.getSource().equals(inserireIndirizzo))
		{
			d = new Dialogo(this,"Programma",true);
			d.setVisible(true);
			messaggioRicevuto = d.getTest();
			
		}
		
	}
	public JTextArea getTesto() {
		return testo;
	}
	public void setTesto(JTextArea testo) {
		this.testo = testo;
	}
	public Dialogo getD() {
		return d;
	}
	public void setD(Dialogo d) {
		this.d = d;
	}

}
