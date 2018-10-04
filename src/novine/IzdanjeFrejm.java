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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IzdanjeFrejm extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Izdanje> listaIzdanja;
	String ime;
	String tip;
	double cijena;

	public IzdanjeFrejm(ArrayList<Izdanje> listaIzdanja) {
		super("Unos izdanja");

		this.listaIzdanja = listaIzdanja;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 300, 300);
		
		//Deklaracija komponenti
		JLabel jlIme = new JLabel("Ime:");
		JLabel jlTip = new JLabel("Tip:");
		JLabel jlCijena = new JLabel("Cijena: ");
		JTextField jtfIme = new JTextField();
		JComboBox<String> jcbTip = new JComboBox<String>();
		jcbTip.addItem("dnevni");
		jcbTip.addItem("nedeljni");
		jcbTip.addItem("mjesecni");
		jcbTip.addItem("tromjesecni");
		JTextField jtfCijena = new JTextField();
		JButton jbUnesi = new JButton("UNESI");
		
		//Pozicioniranje komponenti
		jlIme.setBounds(40, 40, 40, 20);
		jlTip.setBounds(40, 80, 40, 20);
		jlCijena.setBounds(40, 120, 60, 20);
		jtfIme.setBounds(90, 40, 170, 20);
		jcbTip.setBounds(90, 80, 170, 20);
		jtfCijena.setBounds(90, 120, 170, 20);
		jbUnesi.setBounds(60, 200, 180, 50);
		
		//Dodavanje komponenti
		add(jlIme);
		add(jlTip);
		add(jlCijena);
		add(jtfIme);
		add(jcbTip);
		add(jtfCijena);
		add(jbUnesi);
		
		//Action listener
		jbUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean ispravno;
				ime = jtfIme.getText();
				tip = (String) jcbTip.getSelectedItem();
				try {
					if(ime.equals("") || ime == null) {
						JOptionPane.showMessageDialog(null,
							    "Ime ne smije ostati prazno!",
							    "Warning",
							    JOptionPane.WARNING_MESSAGE);
						ispravno = false;
					} else
						ispravno = true;	
					cijena = Double.parseDouble(jtfCijena.getText());
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
						    "Cijena mora da sadrzi brojcanu vrijednost!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					ispravno = false;
				}
				//Provjera uslova da li su sva polja ispravno unijeta, i smjestanje u fajl ako jeste ispravno
				if(ispravno) {
					listaIzdanja.add(new Izdanje(ime, tip, cijena));
					//Unos liste u fajl
					ObjectOutputStream ousIzdanje = null;
					try {
						ousIzdanje = new ObjectOutputStream(new FileOutputStream(new File("Izdanja.txt")));
						for (int i = 0; i < listaIzdanja.size(); i++) {
							ousIzdanje.writeObject(listaIzdanja.get(i));
						}
					} catch (FileNotFoundException e1) {
						System.out.println("Fajl ne postoji!");
					} catch (IOException e2) {
						System.out.println("Podaci se ne mogu upisati u fajl!");
					}
					jtfIme.setText(null);
					jtfCijena.setText(null);
					Frejm.setListaIzdanja(listaIzdanja);
					JOptionPane.showMessageDialog(null,
						    "Podaci su uspjesno sacuvani.",
						    "Message",
						    JOptionPane.PLAIN_MESSAGE);
				} 
				
			}
		});
	}

	

}
