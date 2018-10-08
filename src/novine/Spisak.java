package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

public class Spisak extends JFrame{

	private static final long serialVersionUID = 1L;
	
	ArrayList<Izdanje> listaIzdanja;
	ArrayList<Pretplata> listaPretplata;
	
	public Spisak(ArrayList<Izdanje> listaIzdanja, ArrayList<Pretplata> listaPretplata) {
		super("Spisak izdanja");
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		
		this.listaIzdanja = listaIzdanja;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 620, 700);
		
		//Deklaracija komponenti
		JLabel jlOdaberi = new JLabel("Odaberi izdanje");
		JComboBox<String> jcbOdaberi = new JComboBox<String>();
		JButton jbOsvjezi = new JButton ("Osvjezi");
		JLabel jlNaziv = new JLabel("Naziv:");
		JLabel jlTip = new JLabel("Tip:");
		JLabel jlCijena = new JLabel("Cijena: ");
		JLabel jlBrIzdatih = new JLabel("Br. izdatih primjeraka:");
		JLabel jlZarada = new JLabel("Zarada:");
		JLabel jlLista = new JLabel("Lista svih pretplatnika:");
		JTextField jtfIme = new JTextField();
		JTextField jtfTip = new JTextField();
		JTextField jtfCijena = new JTextField();
		JTextField jtfBrIzdatih = new JTextField();
		JTextField jtfZarada = new JTextField();
		JList<String> jlistLista = new JList<String>(dlm);
		
		//Pozicioniranje komponenti
		jlOdaberi.setBounds(260, 20, 100, 20);
		jcbOdaberi.setBounds(210, 50, 200, 20);
		jbOsvjezi.setBounds(260, 80, 100, 20);
		jlNaziv.setBounds(40, 160, 40, 20);
		jlTip.setBounds(40, 200, 40, 20);
		jlCijena.setBounds(40, 240, 60, 20);
		jlBrIzdatih.setBounds(40, 280, 140, 20);
		jlZarada.setBounds(40, 320, 140, 20);
		jlLista.setBounds(390, 150, 150, 20);
		jtfIme.setBounds(90, 160, 200, 20);
		jtfTip.setBounds(90, 200, 200, 20);
		jtfCijena.setBounds(90, 240, 200, 20);
		jtfBrIzdatih.setBounds(170, 280, 120, 20);
		jtfZarada.setBounds(90, 320, 200, 20);
		jlistLista.setBounds(300, 180, 300, 480);
		
		//Dodavanje komponenti
		add(jcbOdaberi);
		add(jlOdaberi);
		add(jbOsvjezi);
		add(jlNaziv);
		add(jlTip);
		add(jlCijena);
		add(jlBrIzdatih);
		add(jlZarada);
		add(jlLista);
		add(jtfIme);
		add(jtfTip);
		add(jtfCijena);
		add(jtfBrIzdatih);
		add(jtfZarada);
		add(jlistLista);
		
		//Postavaljanje Text Fieldova kao uneditable
		jtfIme.setEditable(false);
		jtfTip.setEditable(false);
		jtfCijena.setEditable(false);
		jtfBrIzdatih.setEditable(false);
		jtfZarada.setEditable(false);
		
		//Popunjavanje combo boxa
		for (int i = 0; i < listaIzdanja.size(); i++) {
			jcbOdaberi.addItem(listaIzdanja.get(i).imeIzdanja);
		}
		
		//Action Listener za "Osvjezi"
		jbOsvjezi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Trazenje indeksa odabranog izdanja
				int indeks = 0;
				for (int i = 0; i < listaIzdanja.size(); i++) {
					if(listaIzdanja.get(i).imeIzdanja.equals(jcbOdaberi.getSelectedItem())) {
						indeks = i;
					}
				}
				jtfIme.setText(listaIzdanja.get(indeks).imeIzdanja);
				jtfTip.setText(listaIzdanja.get(indeks).tipIzdanja);
				jtfCijena.setText("" + listaIzdanja.get(indeks).cijenaPrimjerka);
				//Prebrojavanje izdatih primjeraka
				int brIzdatih = 0;
				for (int i = 0; i < listaPretplata.size(); i++) {
					if(listaPretplata.get(i).izdanje.imeIzdanja.equals(jcbOdaberi.getSelectedItem()))
						brIzdatih += listaPretplata.get(i).brojNarucenihPrimjeraka;
				}
				jtfBrIzdatih.setText("" + brIzdatih);
				jtfZarada.setText((brIzdatih * listaIzdanja.get(indeks).cijenaPrimjerka) + "KM");
				//Dodavanje u listu
				dlm.clear();
				String str;
				for (int i = 0; i < listaPretplata.size(); i++) {
					str = "";
					if(listaPretplata.get(i).izdanje.imeIzdanja.equals(jcbOdaberi.getSelectedItem())) {;
						str += "IME: " + listaPretplata.get(i).pretplatnik.ime;
						str += " | PREZIME: " + listaPretplata.get(i).pretplatnik.prezime;
						dlm.addElement(str);
					}
				}
			}
		});
	}
}
