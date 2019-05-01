package frontend;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Dialogo extends JDialog implements ActionListener{
	private JTextField testotxt;
	private JLabel testo;
	
	private JButton conferma;
	
	private String test;
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}
	public Dialogo (JFrame owner, String title, boolean model)
	{
		super(owner,title,model);
		initComponents();
		setSize(800,800);
	}
	public void initComponents()
	{
		setLayout(new FlowLayout());
		testotxt= new JTextField(50);
		testo = new JLabel("Inserire l' url");
		add(testo);
		add(testotxt);
		
		conferma= new JButton("conferma");
		conferma.addActionListener(this);
		add(conferma);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(conferma))
		{
			test=testotxt.getText();
			this.dispose();
		}
		
	}
	public JTextField getTestotxt() {
		return testotxt;
	}
	public void setTestotxt(JTextField testotxt) {
		this.testotxt = testotxt;
	}

}
