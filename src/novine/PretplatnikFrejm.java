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

public class PretplatnikFrejm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	ArrayList<Pretplatnik> listaPretplatnika = new ArrayList<>();
	String ime;
	String prezime;
	String adresa;
	String brojTelefona;

	public PretplatnikFrejm(ArrayList<Pretplatnik> listaPretplatnika) {
		super("Unos pretplatnika");
		
		this.listaPretplatnika = listaPretplatnika;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 300);
		
		//Deklaracija komponenti
		JLabel jlIme = new JLabel("Ime:");
		JLabel jlPrezime = new JLabel("Prezime:");
		JLabel jlAdresa = new JLabel("Adresa:");
		JLabel jlTelefon = new JLabel("Telefon:");
		JTextField jtfIme = new JTextField();
		JTextField jtfPrezime = new JTextField();
		JTextField jtfAdresa = new JTextField();
		JTextField jtfTelefon = new JTextField();
		JButton jbUnesi = new JButton("UNESI");
		
		//Pozicioniranje komponenti
		jlIme.setBounds(40, 40, 40, 20);
		jlPrezime.setBounds(40, 80, 60, 20);
		jlAdresa.setBounds(40, 120, 60, 20);
		jlTelefon.setBounds(40, 160, 60, 20);
		jtfIme.setBounds(90, 40, 170, 20);
		jtfPrezime.setBounds(90, 80, 170, 20);
		jtfAdresa.setBounds(90, 120, 170, 20);
		jtfTelefon.setBounds(90, 160, 170, 20);
		jbUnesi.setBounds(60, 200, 180, 50);
		
		//Dodavanje komponenti
		add(jlIme);
		add(jlPrezime);
		add(jlAdresa);
		add(jlTelefon);
		add(jtfIme);
		add(jtfPrezime);
		add(jtfAdresa);
		add(jtfTelefon);
		add(jbUnesi);
		
		//Action listener
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ime = jtfIme.getText();
				prezime = jtfPrezime.getText();
				adresa = jtfAdresa.getText();
				brojTelefona = jtfTelefon.getText();
				//Provjera uslova da li su sva polja ispravno unijeta, i smjestanje u fajl ako jeste ispravno
				if(ime.equals("") || ime == null || prezime.equals("") || prezime == null || adresa.equals("") || adresa == null || brojTelefona.equals("") || brojTelefona == null) {
					JOptionPane.showMessageDialog(null,
						    "Morate unijeti sva polja!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				} else {
					listaPretplatnika.add(new Pretplatnik(ime, prezime, adresa, brojTelefona));
					
					//Unos liste u fajl
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
					JOptionPane.showMessageDialog(null,
						    "Podaci su uspjesno sacuvani.",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);	
				}
								
			}
		});
	}
}
