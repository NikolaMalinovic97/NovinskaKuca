package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class ListanjeSamoOdredjenogTipaIzdanja extends JFrame{

	private static final long serialVersionUID = 1L;

	ArrayList<Izdanje> listaIzdanja;
	String str;
	
	public ListanjeSamoOdredjenogTipaIzdanja(ArrayList<Izdanje> listaIzdanja) {
		super("Lista jednog tipa izdanja");
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		this.listaIzdanja = listaIzdanja;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 620, 700);
		
		// Deklaracija komponenti
		JButton jbDnevni = new JButton("Dnevni");
		JButton jbNedeljni = new JButton("Nedeljni");
		JButton jbMjesecni = new JButton("Mjesecni");
		JButton jbTromjesecni = new JButton("Tromjesecni");
		JList<String> jlLista = new JList<String>(dlm);
		
		// Pozicioniranje komponenti
		jbDnevni.setBounds(12, 10, 140, 40);
		jbNedeljni.setBounds(164, 10, 140, 40);
		jbMjesecni.setBounds(316, 10, 140, 40);
		jbTromjesecni.setBounds(466, 10, 140, 40);
		jlLista.setBounds(10, 60, 600, 600);

		// Dodavanje komponenti
		add(jbDnevni);
		add(jbNedeljni);
		add(jbMjesecni);
		add(jbTromjesecni);
		add(jlLista);	
		
		//Action listener za dugme "Dnevni"
		jbDnevni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Dodavanje u listu
				dlm.clear();
				for (int i = 0; i < listaIzdanja.size(); i++) {
					if(listaIzdanja.get(i).tipIzdanja.equals("dnevni")) {
						str = "";
						str += "IME: " + listaIzdanja.get(i).imeIzdanja;
						str += " | TIP: " + listaIzdanja.get(i).tipIzdanja;
						str += " | CIJENA: " + listaIzdanja.get(i).cijenaPrimjerka;
						dlm.addElement(str);
					}				
				}
				
			}
		});
		
		//Action listener za dugme "Nedeljni"
		jbNedeljni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Dodavanje u listu
				dlm.clear();
				for (int i = 0; i < listaIzdanja.size(); i++) {
					if(listaIzdanja.get(i).tipIzdanja.equals("nedeljni")) {
						str = "";
						str += "IME: " + listaIzdanja.get(i).imeIzdanja;
						str += " | TIP: " + listaIzdanja.get(i).tipIzdanja;
						str += " | CIJENA: " + listaIzdanja.get(i).cijenaPrimjerka;
						dlm.addElement(str);
					}				
				}
				
			}
		});
		
		//Action listener za dugme "Mjesecni"
		jbMjesecni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Dodavanje u listu
				dlm.clear();
				for (int i = 0; i < listaIzdanja.size(); i++) {
					if(listaIzdanja.get(i).tipIzdanja.equals("mjesecni")) {
						str = "";
						str += "IME: " + listaIzdanja.get(i).imeIzdanja;
						str += " | TIP: " + listaIzdanja.get(i).tipIzdanja;
						str += " | CIJENA: " + listaIzdanja.get(i).cijenaPrimjerka;
						dlm.addElement(str);
					}				
				}
				
			}
		});
		
		//Action listener za dugme "Tromjesecni"
		jbTromjesecni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Dodavanje u listu
				dlm.clear();
				for (int i = 0; i < listaIzdanja.size(); i++) {
					if(listaIzdanja.get(i).tipIzdanja.equals("tromjesecni")) {
						str = "";
						str += "IME: " + listaIzdanja.get(i).imeIzdanja;
						str += " | TIP: " + listaIzdanja.get(i).tipIzdanja;
						str += " | CIJENA: " + listaIzdanja.get(i).cijenaPrimjerka;
						dlm.addElement(str);
					}				
				}
				
			}
		});
	}


}
