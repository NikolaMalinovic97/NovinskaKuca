package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class ListanjeSvihPretplataZaOdredjenogPretplatnika extends JFrame{

	private static final long serialVersionUID = 1L;
	
	ArrayList<Pretplata> listaPretplata;
	String str;
	String unosIme;
	String unosPrezime;
	
	public ListanjeSvihPretplataZaOdredjenogPretplatnika(ArrayList<Pretplata> listaPretplata) {
		super("Lista pretplatna za odredjenog pretplatnika");
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		this.listaPretplata = listaPretplata;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 620, 700);
		
		// Deklaracija komponenti
		JLabel jlIme = new JLabel("Ime:");
		JLabel jlPrezime = new JLabel("Prezime:");
		JTextField jtfIme = new JTextField();
		JTextField jtfPrezime = new JTextField();
		JButton jbUnesi = new JButton("Unesi");
		JList<String> jlLista = new JList<String>(dlm);
		
		// Pozicioniranje komponenti
		jlIme.setBounds(20, 5, 50, 20);
		jlPrezime.setBounds(20, 30, 50, 20);
		jtfIme.setBounds(80, 5, 140, 20);
		jtfPrezime.setBounds(80, 30, 140, 20);
		jbUnesi.setBounds(330, 10, 140, 40);
		jlLista.setBounds(10, 60, 600, 600);

		// Dodavanje komponenti
		add(jlIme);
		add(jlPrezime);
		add(jtfIme);
		add(jtfPrezime);
		add(jbUnesi);
		add(jlLista);
		
		//Action listener za dugme "Unesi"
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unosIme = jtfIme.getText();
				unosPrezime = jtfPrezime.getText();
				//Dodavanje u listu
				dlm.clear();
				for (int i = 0; i < listaPretplata.size(); i++) {
					if(listaPretplata.get(i).pretplatnik.ime.equals(unosIme) && listaPretplata.get(i).pretplatnik.prezime.equals(unosPrezime)) {
						str = "";
						str += "NAZIV: " + listaPretplata.get(i).izdanje.imeIzdanja;
						str += " | BR. NARUCENIH PRIMJERAKA: " + listaPretplata.get(i).brojNarucenihPrimjeraka;
						str += " | GODINA PRETPLATE: " + listaPretplata.get(i).godinaPretplate;
						dlm.addElement(str);
					}				
				}
				
			}
		});
	}
}
