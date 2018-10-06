package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class ListaSvihPretplatnikaSortiranaPoPrezimenuIliPoDugovanju extends JFrame{

	private static final long serialVersionUID = 1L;

	ArrayList<Pretplatnik> listaPretplatnika;
	String str;
	
	public ListaSvihPretplatnikaSortiranaPoPrezimenuIliPoDugovanju(ArrayList<Pretplatnik> listaPretplatnika) {
		super("Lista pretplatnika");

		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		this.listaPretplatnika = listaPretplatnika;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 620, 700);
		
		// Deklaracija komponenti
		JButton jbPrezime = new JButton("Po prezimenu");
		JButton jbDugovanje = new JButton("Po dugovanju");
		JList<String> jlLista = new JList<String>(dlm);
		
		// Pozicioniranje komponenti
		jbPrezime.setBounds(120, 10, 140, 40);
		jbDugovanje.setBounds(350, 10, 140, 40);
		jlLista.setBounds(10, 60, 600, 600);

		// Dodavanje komponenti
		add(jbPrezime);
		add(jbDugovanje);
		add(jlLista);
		
		
		
		//Action listener za dugme "Po prezimenu"
		jbPrezime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sortiranje
				String zamjenaIme;
				String zamjenaPrezime;
				String zamjenaAdresa;
				String zamjenaTelefon;
				double zamjenaSaldo;
				for (int j = 0; j < listaPretplatnika.size() - 1; j++) {
					for (int i = 0; i < listaPretplatnika.size() - 1; i++) {
						for (int k = 0; k < 4; k++) {
							if(listaPretplatnika.get(i).prezime.charAt(k) != listaPretplatnika.get(i + 1).prezime.charAt(k)) {
								if(listaPretplatnika.get(i).prezime.charAt(k) < listaPretplatnika.get(i + 1).prezime.charAt(k)) {
									zamjenaIme = listaPretplatnika.get(i).ime;
									zamjenaPrezime = listaPretplatnika.get(i).prezime;
									zamjenaAdresa = listaPretplatnika.get(i).adresa;
									zamjenaTelefon = listaPretplatnika.get(i).brojTelefona;
									zamjenaSaldo = listaPretplatnika.get(i).saldo;
									listaPretplatnika.get(i).ime = listaPretplatnika.get(i + 1).ime;
									listaPretplatnika.get(i).prezime = listaPretplatnika.get(i + 1).prezime;
									listaPretplatnika.get(i).adresa = listaPretplatnika.get(i + 1).adresa;
									listaPretplatnika.get(i).brojTelefona = listaPretplatnika.get(i + 1).brojTelefona;
									listaPretplatnika.get(i).saldo = listaPretplatnika.get(i + 1).saldo;
									listaPretplatnika.get(i + 1).ime = zamjenaIme;
									listaPretplatnika.get(i + 1).prezime = zamjenaPrezime;
									listaPretplatnika.get(i + 1).adresa = zamjenaAdresa;
									listaPretplatnika.get(i + 1).brojTelefona = zamjenaTelefon;
									listaPretplatnika.get(i + 1).saldo = zamjenaSaldo;
								}
								break;
							}
						}
										
						
					}
				}
				//Dodavanje u listu
				dlm.clear();
				for (int i = listaPretplatnika.size() - 1; i >= 0; i--) {
					str = "";
					str += "IME: " + listaPretplatnika.get(i).ime;
					str += " | PREZIME: " + listaPretplatnika.get(i).prezime;
					str += " | ADRESA: " + listaPretplatnika.get(i).adresa;
					str += " | TELEFON: " + listaPretplatnika.get(i).brojTelefona;
					str += " | SALDO: " + listaPretplatnika.get(i).saldo;
					dlm.addElement(str);
				}
				
			}
		});
		
		
		//Action listener za dugme "Po prezimenu"
		jbDugovanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sortiranje
				String zamjenaIme;
				String zamjenaPrezime;
				String zamjenaAdresa;
				String zamjenaTelefon;
				double zamjenaSaldo;
				for (int j = 0; j < listaPretplatnika.size() - 1; j++) {
					for (int i = 0; i < listaPretplatnika.size() - 1; i++) {
						if(listaPretplatnika.get(i).saldo < listaPretplatnika.get(i + 1).saldo) {
							zamjenaIme = listaPretplatnika.get(i).ime;
							zamjenaPrezime = listaPretplatnika.get(i).prezime;
							zamjenaAdresa = listaPretplatnika.get(i).adresa;
							zamjenaTelefon = listaPretplatnika.get(i).brojTelefona;
							zamjenaSaldo = listaPretplatnika.get(i).saldo;
							listaPretplatnika.get(i).ime = listaPretplatnika.get(i + 1).ime;
							listaPretplatnika.get(i).prezime = listaPretplatnika.get(i + 1).prezime;
							listaPretplatnika.get(i).adresa = listaPretplatnika.get(i + 1).adresa;
							listaPretplatnika.get(i).brojTelefona = listaPretplatnika.get(i + 1).brojTelefona;
							listaPretplatnika.get(i).saldo = listaPretplatnika.get(i + 1).saldo;
							listaPretplatnika.get(i + 1).ime = zamjenaIme;
							listaPretplatnika.get(i + 1).prezime = zamjenaPrezime;
							listaPretplatnika.get(i + 1).adresa = zamjenaAdresa;
							listaPretplatnika.get(i + 1).brojTelefona = zamjenaTelefon;
							listaPretplatnika.get(i + 1).saldo = zamjenaSaldo;
						}
					}
				}
				//Dodavanje u listu
				dlm.clear();
				for (int i = listaPretplatnika.size() - 1; i >= 0; i--) {
					str = "";
					str += "IME: " + listaPretplatnika.get(i).ime;
					str += " | PREZIME: " + listaPretplatnika.get(i).prezime;
					str += " | ADRESA: " + listaPretplatnika.get(i).adresa;
					str += " | TELEFON: " + listaPretplatnika.get(i).brojTelefona;
					str += " | SALDO: " + listaPretplatnika.get(i).saldo;
					dlm.addElement(str);
				}
				
			}
		});
	}
}
