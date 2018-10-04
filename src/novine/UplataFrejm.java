package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UplataFrejm extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<Pretplatnik> listaPretplatnika;
	String ime;
	String prezime;
	double iznosUplate;

	public UplataFrejm(ArrayList<Pretplatnik> listaPretplatnika) {

		super("Unos uplate");

		this.listaPretplatnika = listaPretplatnika;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 300);

		// Deklaracija komponenti
		JLabel jlIme = new JLabel("Ime:");
		JLabel jlPrezime = new JLabel("Prezime:");
		JLabel jlIznos = new JLabel("Iznos:");
		JTextField jtfIme = new JTextField();
		JTextField jtfPrezime = new JTextField();
		JTextField jtfIznos = new JTextField();
		JButton jbUnesi = new JButton("UNESI");

		// Pozicioniranje komponenti
		jlIme.setBounds(40, 40, 40, 20);
		jlPrezime.setBounds(40, 80, 60, 20);
		jlIznos.setBounds(40, 120, 60, 20);
		jtfIme.setBounds(90, 40, 170, 20);
		jtfPrezime.setBounds(90, 80, 170, 20);
		jtfIznos.setBounds(90, 120, 170, 20);
		jbUnesi.setBounds(60, 200, 180, 50);

		// Dodavanje komponenti
		add(jlIme);
		add(jlPrezime);
		add(jlIznos);
		add(jtfIme);
		add(jtfPrezime);
		add(jtfIznos);
		add(jbUnesi);

		// Action listener
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ispravno = true;
				ime = jtfIme.getText();
				prezime = jtfPrezime.getText();
				// Provjera uslova da li su sva polja ispravno unijeta
				if (ime.equals("") || ime == null || prezime.equals("") || prezime == null) {
					JOptionPane.showMessageDialog(null, "Morate unijeti sva polja!", "Warning",
							JOptionPane.WARNING_MESSAGE);
					ispravno = false;
				} else {
					try {
						iznosUplate = Double.parseDouble(jtfIznos.getText());
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null,
							    "Cijena mora da sadrzi brojcanu vrijednost!",
							    "Warning",
							    JOptionPane.WARNING_MESSAGE);
						ispravno = false;
					}
				} 
				//Smjerstanje podataka u fajl ako su ispravno unijeti
				if(ispravno) {
					dodajSaldo();
					// Unos liste u fajl
					ObjectOutputStream ousPretplatnik = null;
					try {
						ousPretplatnik = new ObjectOutputStream(new FileOutputStream(new File("Pretplatnici.txt")));
						for (int i = 0; i < listaPretplatnika.size(); i++) {
							ousPretplatnik.writeObject(listaPretplatnika.get(i));
						}
					} catch (FileNotFoundException e1) {
						System.out.println("Fajl ne postoji!");
					} catch (IOException e2) {
						System.out.println("Podaci se ne mogu upisati u fajl!");
					}
					jtfIme.setText(null);
					jtfPrezime.setText(null);
					jtfIznos.setText(null);
					Frejm.setListaPretplatnika(listaPretplatnika);
					JOptionPane.showMessageDialog(null, "Podaci su uspjesno sacuvani.", "Message",
							JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}
	
	public void dodajSaldo() {
		for (int i = 0; i < listaPretplatnika.size(); i++) {
			if(listaPretplatnika.get(i).ime.equals(this.ime) && listaPretplatnika.get(i).prezime.equals(this.prezime)) {
				listaPretplatnika.get(i).saldo += iznosUplate;
				break;
			}
		}
	}
}
