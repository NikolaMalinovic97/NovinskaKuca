package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class ListanjeSvihIzdanjaSortiranihPoNazivuIliCijeni extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<Izdanje> listaIzdanja;
	String str;
	
	public ListanjeSvihIzdanjaSortiranihPoNazivuIliCijeni(ArrayList<Izdanje> listaIzdanja) {
		super("Lista izdanja");

		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		this.listaIzdanja = listaIzdanja;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 620, 700);
		
		// Deklaracija komponenti
		JButton jbNaziv = new JButton("Po nazivu");
		JButton jbCijena = new JButton("Po cijeni");
		JList<String> jlLista = new JList<String>(dlm);
		
		// Pozicioniranje komponenti
		jbNaziv.setBounds(120, 10, 140, 40);
		jbCijena.setBounds(350, 10, 140, 40);
		jlLista.setBounds(10, 60, 600, 600);

		// Dodavanje komponenti
		add(jbNaziv);
		add(jbCijena);
		add(jlLista);
		
		//Action listener za dugme "Po nazivu"
		jbNaziv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sortiranje
				String zamjenaIme;
				String zamjenaTip;
				double zamjenaCijena;
				for (int j = 0; j < listaIzdanja.size() - 1; j++) {
					for (int i = 0; i < listaIzdanja.size() - 1; i++) {
						for (int k = 0; k < 3; k++) {
							if(listaIzdanja.get(i).imeIzdanja.charAt(k) != listaIzdanja.get(i + 1).imeIzdanja.charAt(k)) {
								if(listaIzdanja.get(i).imeIzdanja.charAt(k) > listaIzdanja.get(i + 1).imeIzdanja.charAt(k)) {
									zamjenaIme = listaIzdanja.get(i).imeIzdanja;
									zamjenaTip = listaIzdanja.get(i).tipIzdanja;
									zamjenaCijena = listaIzdanja.get(i).cijenaPrimjerka;
									listaIzdanja.get(i).imeIzdanja = listaIzdanja.get(i + 1).imeIzdanja;
									listaIzdanja.get(i).tipIzdanja = listaIzdanja.get(i + 1).tipIzdanja;
									listaIzdanja.get(i).cijenaPrimjerka = listaIzdanja.get(i + 1).cijenaPrimjerka;
									listaIzdanja.get(i + 1).imeIzdanja = zamjenaIme;
									listaIzdanja.get(i + 1).tipIzdanja = zamjenaTip;
									listaIzdanja.get(i + 1).cijenaPrimjerka = zamjenaCijena;
								}
								break;
							}
						}
										
						
					}
				}
				//Dodavanje u listu
				dlm.clear();
				for (int i = listaIzdanja.size() - 1; i >= 0; i--) {
					str = "";
					str += "IME: " + listaIzdanja.get(i).imeIzdanja;
					str += " | TIP: " + listaIzdanja.get(i).tipIzdanja;
					str += " | CIJENA: " + listaIzdanja.get(i).cijenaPrimjerka;
					dlm.addElement(str);
				}
				
			}
		});
		
		//Action listener za dugme "Po cijeni"
		jbCijena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Sortiranje
				String zamjenaIme;
				String zamjenaTip;
				double zamjenaCijena;
				for (int j = 0; j < listaIzdanja.size() - 1; j++) {
					for (int i = 0; i < listaIzdanja.size() - 1; i++) {
						if(listaIzdanja.get(i).cijenaPrimjerka > listaIzdanja.get(i + 1).cijenaPrimjerka) {
							zamjenaIme = listaIzdanja.get(i).imeIzdanja;
							zamjenaTip = listaIzdanja.get(i).tipIzdanja;
							zamjenaCijena = listaIzdanja.get(i).cijenaPrimjerka;
							listaIzdanja.get(i).imeIzdanja = listaIzdanja.get(i + 1).imeIzdanja;
							listaIzdanja.get(i).tipIzdanja = listaIzdanja.get(i + 1).tipIzdanja;
							listaIzdanja.get(i).cijenaPrimjerka = listaIzdanja.get(i + 1).cijenaPrimjerka;
							listaIzdanja.get(i + 1).imeIzdanja = zamjenaIme;
							listaIzdanja.get(i + 1).tipIzdanja = zamjenaTip;
							listaIzdanja.get(i + 1).cijenaPrimjerka = zamjenaCijena;
						}
					}
				}
				//Dodavanje u listu
				dlm.clear();
				for (int i = listaIzdanja.size() - 1; i >= 0; i--) {
					str = "";
					str += "IME: " + listaIzdanja.get(i).imeIzdanja;
					str += " | TIP: " + listaIzdanja.get(i).tipIzdanja;
					str += " | CIJENA: " + listaIzdanja.get(i).cijenaPrimjerka;
					dlm.addElement(str);
				}
				
			}
		});
	}
}
