package novine;

import javax.swing.*;

public class Frejm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Frejm() {
		super("Novinska kuca");
		setVisible(true);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Deklaracija dugmadi
		JButton unosIzdanja = new JButton("Unos izdanja");
		JButton unosPretplatnika = new JButton("Unos pretplatnika");
		JButton unosPretplate = new JButton("Unos pretplate");
		
		//Pozicioniranje dugmadi
		unosIzdanja.setBounds(30, 30, 200, 40);
		unosPretplatnika.setBounds(30, 90, 200, 40);
		unosPretplate.setBounds(30, 150, 200, 40);
		
		//Dodavanje dugmadi
		add(unosIzdanja);
		add(unosPretplatnika);
		add(unosPretplate);
		
	}

}
