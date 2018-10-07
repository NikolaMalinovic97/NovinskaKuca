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

public class ListanjeSvihPretplatnikaZaOdredjenoIzdanje extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Pretplata> listaPretplata;
	String str;
	String unos;

	public ListanjeSvihPretplatnikaZaOdredjenoIzdanje(ArrayList<Pretplata> listaPretplata) {
		super("Lista pretplatnika za odredjeno izdanje");
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		this.listaPretplata = listaPretplata;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 620, 700);
		
		// Deklaracija komponenti
		JLabel jlIzdanje = new JLabel("Izdanje:");
		JTextField jtfIzdanje = new JTextField();
		JButton jbUnesi = new JButton("Unesi");
		JList<String> jlLista = new JList<String>(dlm);
		
		// Pozicioniranje komponenti
		jlIzdanje.setBounds(20, 20, 50, 20);
		jtfIzdanje.setBounds(70, 20, 140, 20);
		jbUnesi.setBounds(330, 10, 140, 40);
		jlLista.setBounds(10, 60, 600, 600);

		// Dodavanje komponenti
		add(jlIzdanje);
		add(jtfIzdanje);
		add(jbUnesi);
		add(jlLista);
		
		//Action listener za dugme "Unesi"
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unos = jtfIzdanje.getText();
				//Dodavanje u listu
				dlm.clear();
				for (int i = 0; i < listaPretplata.size(); i++) {
					if(listaPretplata.get(i).izdanje.imeIzdanja.equals(unos)) {
						str = "";
						str += "IME: " + listaPretplata.get(i).pretplatnik.ime;
						str += " | PREZIME: " + listaPretplata.get(i).pretplatnik.prezime;
						str += " | ADRESA: " + listaPretplata.get(i).pretplatnik.adresa;
						str += " | TELEFON: " + listaPretplata.get(i).pretplatnik.brojTelefona;
						dlm.addElement(str);
					}				
				}
				
			}
		});
	}

}
