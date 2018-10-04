package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SaldoJednogPretplatnikaFrejm extends JFrame {

	private static final long serialVersionUID = 1L;

	ArrayList<Pretplatnik> listaPretplatnika;
	String ime;
	String prezime;
	double saldo;

	public SaldoJednogPretplatnikaFrejm(ArrayList<Pretplatnik> listaPretplatnika) {
		super("Unos pretplatnika");

		this.listaPretplatnika = listaPretplatnika;

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 300);

		// Deklaracija komponenti
		JLabel jlIme = new JLabel("Ime:");
		JLabel jlPrezime = new JLabel("Prezime:");
		JLabel jlSaldo = new JLabel("Saldo:");
		JTextField jtfIme = new JTextField();
		JTextField jtfPrezime = new JTextField();
		JTextField jtfSaldo = new JTextField();
		jtfSaldo.setEditable(false);
		JButton jbUnesi = new JButton("UNESI");

		// Pozicioniranje komponenti
		jlIme.setBounds(40, 40, 40, 20);
		jlPrezime.setBounds(40, 80, 60, 20);
		jlSaldo.setBounds(40, 120, 60, 20);
		jtfIme.setBounds(90, 40, 170, 20);
		jtfPrezime.setBounds(90, 80, 170, 20);
		jtfSaldo.setBounds(90, 120, 170, 20);
		jbUnesi.setBounds(60, 200, 180, 50);

		// Dodavanje komponenti
		add(jlIme);
		add(jlPrezime);
		add(jlSaldo);
		add(jtfIme);
		add(jtfPrezime);
		add(jtfSaldo);
		add(jbUnesi);

		// Action listener
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ime = jtfIme.getText();
				prezime = jtfPrezime.getText();
				// Provjera uslova da li su sva polja ispravno unijeta, i smjestanje u fajl ako
				// jeste ispravno
				if (ime.equals("") || ime == null || prezime.equals("") || prezime == null) {
					JOptionPane.showMessageDialog(null, "Morate unijeti sva polja!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (! postojiPretplatnik(ime, prezime)){
					JOptionPane.showMessageDialog(null, "Pretplatnik kojeg ste unijeli ne postoji!", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					for (int i = 0; i < listaPretplatnika.size(); i++) {
						if(listaPretplatnika.get(i).ime.equals(ime) && listaPretplatnika.get(i).prezime.equals(prezime)) {
							saldo = listaPretplatnika.get(i).saldo;
							jtfSaldo.setText("" + saldo);
							break;
						}
					}
				}

			}
		});
	}
	
	public boolean postojiPretplatnik(String ime, String prezime) {
		for (int i = 0; i < listaPretplatnika.size(); i++) {
			if (listaPretplatnika.get(i).ime.equals(ime) && listaPretplatnika.get(i).prezime.equals(prezime))
				return true;
		}
		return false;
	}
}
