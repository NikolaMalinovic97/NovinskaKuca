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

public class PretplataFrejm extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<Izdanje> listaIzdanja;
	ArrayList<Pretplatnik> listaPretplatnika;
	ArrayList<Pretplata> listaPretplata;
	String imePretplatnika;
	String prezimePretplatnika;
	Pretplatnik pretplatnik = null;
	String imeIzdanja;
	Izdanje izdanje = null;
	int godinaPretplate;
	int brojNarucenihPrimjeraka;

	public PretplataFrejm(ArrayList<Izdanje> listaIzdanja, ArrayList<Pretplatnik> listaPretplatnika,
			ArrayList<Pretplata> listaPretplata) {
		super("Unos pretplate");

		this.listaIzdanja = listaIzdanja;
		this.listaPretplatnika = listaPretplatnika;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 340);

		// Deklaracija komponenti
		JLabel jlImePretplatnika = new JLabel("Ime pretplatnika:");
		JLabel jlPrezimePretplatnika = new JLabel("Prezime pretplatnika:");
		JLabel jlImeIzdanja = new JLabel("Ime izdanja: ");
		JLabel jlGodinaPretplate = new JLabel("Godina pretplate:");
		JLabel jlBrojPrimjeraka = new JLabel("Broj primjeraka:");
		JTextField jtfImePretplatnika = new JTextField();
		JTextField jtfPrezimePretplatnika = new JTextField();
		JTextField jtfImeIzdanja = new JTextField();
		JTextField jtfGodinaPretplate = new JTextField();
		JTextField jtfBrojPrimjeraka = new JTextField();
		JButton jbUnesi = new JButton("UNESI");

		// Pozicioniranje komponenti
		jlImePretplatnika.setBounds(10, 40, 100, 20);
		jlPrezimePretplatnika.setBounds(10, 80, 130, 20);
		jlImeIzdanja.setBounds(10, 120, 100, 20);
		jlGodinaPretplate.setBounds(10, 160, 100, 20);
		jlBrojPrimjeraka.setBounds(10, 200, 100, 20);
		jtfImePretplatnika.setBounds(140, 40, 140, 20);
		jtfPrezimePretplatnika.setBounds(140, 80, 140, 20);
		jtfImeIzdanja.setBounds(140, 120, 140, 20);
		jtfGodinaPretplate.setBounds(140, 160, 140, 20);
		jtfBrojPrimjeraka.setBounds(140, 200, 140, 20);
		jbUnesi.setBounds(60, 240, 180, 50);

		// Dodavanje komponenti
		add(jlImePretplatnika);
		add(jlPrezimePretplatnika);
		add(jlImeIzdanja);
		add(jlGodinaPretplate);
		add(jlBrojPrimjeraka);
		add(jtfImePretplatnika);
		add(jtfPrezimePretplatnika);
		add(jtfImeIzdanja);
		add(jtfGodinaPretplate);
		add(jtfBrojPrimjeraka);
		add(jbUnesi);

		// Action listener
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imePretplatnika = jtfImePretplatnika.getText();
				prezimePretplatnika = jtfPrezimePretplatnika.getText();
				imeIzdanja = jtfImeIzdanja.getText();
				godinaPretplate = Integer.parseInt(jtfGodinaPretplate.getText());
				brojNarucenihPrimjeraka = Integer.parseInt(jtfBrojPrimjeraka.getText());
				// Provjera uslova da li su sva polja ispravno unijeta, i smjestanje u fajl ako
				// jeste ispravno
				if (imePretplatnika.equals("") || imePretplatnika == null || prezimePretplatnika.equals("")
						|| prezimePretplatnika == null || imeIzdanja.equals("") || imeIzdanja == null) {
					JOptionPane.showMessageDialog(null, "Morate unijeti sva polja!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (! postojiIzdanje(imeIzdanja)) {
					JOptionPane.showMessageDialog(null, "Izdanje koje ste unijeli ne postoji!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (! postojiPretplatnik(imePretplatnika, prezimePretplatnika)) {
					JOptionPane.showMessageDialog(null, "Pretplatnik kojeg ste unijeli ne postoji!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					oduzmiSaldo();
					listaPretplata.add(new Pretplata(unesiPretplatnika(imePretplatnika, prezimePretplatnika), unesiIzdanje(imeIzdanja), godinaPretplate, brojNarucenihPrimjeraka));
					// Unos liste u fajl
					ObjectOutputStream ousPretplata = null;
					try {
						ousPretplata = new ObjectOutputStream(new FileOutputStream(new File("Pretplate.txt")));
						for (int i = 0; i < listaPretplata.size(); i++) {
							ousPretplata.writeObject(listaPretplata.get(i));
						}
					} catch (FileNotFoundException e1) {
						System.out.println("Fajl ne postoji!");
					} catch (IOException e2) {
						System.out.println("Podaci se ne mogu upisati u fajl!");
					}
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
					jtfImePretplatnika.setText(null);
					jtfPrezimePretplatnika.setText(null);
					jtfImeIzdanja.setText(null);
					jtfGodinaPretplate.setText(null);
					jtfBrojPrimjeraka.setText(null);
					Frejm.setListaPretplata(listaPretplata);
					Frejm.setListaPretplatnika(listaPretplatnika);
					JOptionPane.showMessageDialog(null, "Podaci su uspjesno sacuvani.", "Message",
							JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}

	public boolean postojiIzdanje(String imeIzdanja) {
		for (int i = 0; i < listaIzdanja.size(); i++) {
			if (listaIzdanja.get(i).imeIzdanja.equals(imeIzdanja))
				return true;
		}
		return false;
	}
	
	public boolean postojiPretplatnik(String ime, String prezime) {
		for (int i = 0; i < listaPretplatnika.size(); i++) {
			if (listaPretplatnika.get(i).ime.equals(ime) && listaPretplatnika.get(i).prezime.equals(prezime))
				return true;
		}
		return false;
	}
	
	public Izdanje unesiIzdanje(String imeIz) {
		Izdanje i = null;
		for (int j = 0; j < listaIzdanja.size(); j++) {
			if(listaIzdanja.get(j).imeIzdanja.equals(imeIz)) {
				i = listaIzdanja.get(j);
				break;
			}
		}
		return i;
	}
	
	public Pretplatnik unesiPretplatnika(String imePretplatnika, String prezimePretplatnika) {
		Pretplatnik p = null;
		for (int j = 0; j < listaPretplatnika.size(); j++) {
			if(listaPretplatnika.get(j).ime.equals(imePretplatnika) && listaPretplatnika.get(j).prezime.equals(prezimePretplatnika)) {
				p = listaPretplatnika.get(j);
				break;
			}
		}
		return p;
	}
	
	public void oduzmiSaldo() {
		int indeksPretplatnika = 0;
		int indeksIzdanja = 0;
		for (int j = 0; j < listaPretplatnika.size(); j++) {
			if(listaPretplatnika.get(j).ime.equals(imePretplatnika) && listaPretplatnika.get(j).prezime.equals(prezimePretplatnika)) {
				indeksPretplatnika = j;
				break;
			}
		}
		for (int j = 0; j < listaIzdanja.size(); j++) {
			if(listaIzdanja.get(j).imeIzdanja.equals(imeIzdanja)) {
				indeksIzdanja = j;
				break;
			}
		}
		listaPretplatnika.get(indeksPretplatnika).saldo -= brojNarucenihPrimjeraka * listaIzdanja.get(indeksIzdanja).cijenaPrimjerka;
	}
}
