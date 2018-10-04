package novine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Frejm extends JFrame {

	private static final long serialVersionUID = 1L;
	
	static ArrayList<Izdanje> listaIzdanja;
	static ArrayList<Pretplatnik> listaPretplatnika;
	static ArrayList<Pretplata> listaPretplata;
	
	public Frejm(ArrayList<Izdanje> listaIzdanja, ArrayList<Pretplatnik> listaPretplatnika, ArrayList<Pretplata> listaPretplata) {
		super("Novinska kuca");
		
		Frejm.listaIzdanja = listaIzdanja;
		Frejm.listaPretplatnika = listaPretplatnika;
		Frejm.listaPretplata = listaPretplata;
		
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setBounds(this.getWidth(), this.getHeight(), 1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Deklaracija dugmadi
		JLabel unosi = new JLabel("UNOSI");
		JButton unosIzdanja = new JButton("Unos izdanja");
		JButton unosPretplatnika = new JButton("Unos pretplatnika");
		JButton unosPretplate = new JButton("Unos pretplate");
		JButton unosUplate = new JButton("Unos uplate");
		JLabel spisak = new JLabel("SPISAK");
		JButton spiskSaKompletnimPodacimaZaJednoIzabranoIzdanje = new JButton("Spisak sa kompletnim podacima za jedno izabrano izdanje");
		JLabel listanje = new JLabel("LISTANJE");
		JButton listanjeSvihPretplatnikaZaOdredjenoIzdanje = new JButton("Listanje svih pretplatnika za odredjeno izdanje");
		JButton listanjeSvihPretplataZaOdredjenogPretplatnika = new JButton("Listanje svih pretplata za odredjenog pretplatnika");
		JButton saldoJednogPretplatnika = new JButton("Saldo jednog pretplatnika");
		JButton listaSvihPretplatnikaSortiranaPoPrezimenuIliPoDugovanju = new JButton("Lista svih pretplatnika sortirana po prezimenu ili po dugovanju");
		JButton listanjeSvihIzdanjaSortiranihPoNazivuIliCeni = new JButton("Listanje svih izdanja sortiranih po nazivu ili ceni");
		JButton listanjeSamoOdredjenogTipaIzdanja = new JButton("Listanje samo odredjenog tipa izdanja");
		
		//Pozicioniranje dugmadi
		unosi.setBounds(160, 40, 40, 50);
		unosIzdanja.setBounds(80, 120, 200, 40);
		unosPretplatnika.setBounds(80, 180, 200, 40);
		unosPretplate.setBounds(80, 240, 200, 40);
		unosUplate.setBounds(80, 300, 200, 40);
		spisak.setBounds(250, 380, 60, 40);
		spiskSaKompletnimPodacimaZaJednoIzabranoIzdanje.setBounds(80, 420, 400, 40);
		listanje.setBounds(695, 40, 60, 50);
		listanjeSvihPretplatnikaZaOdredjenoIzdanje.setBounds(520, 120, 400, 40);
		listanjeSvihPretplataZaOdredjenogPretplatnika.setBounds(520, 180, 400, 40);
		saldoJednogPretplatnika.setBounds(520, 240, 400, 40);
		listaSvihPretplatnikaSortiranaPoPrezimenuIliPoDugovanju.setBounds(520, 300, 400, 40);
		listanjeSvihIzdanjaSortiranihPoNazivuIliCeni.setBounds(520, 360, 400, 40);
		listanjeSamoOdredjenogTipaIzdanja.setBounds(520, 420, 400, 40);
		
		//Dodavanje dugmadi
		add(unosi);
		add(unosIzdanja);
		add(unosPretplatnika);
		add(unosPretplate);
		add(unosUplate);
		add(spisak);
		add(spiskSaKompletnimPodacimaZaJednoIzabranoIzdanje);
		add(listanje);
		add(listanjeSvihPretplatnikaZaOdredjenoIzdanje);
		add(listanjeSvihPretplataZaOdredjenogPretplatnika);
		add(saldoJednogPretplatnika);
		add(listaSvihPretplatnikaSortiranaPoPrezimenuIliPoDugovanju);
		add(listanjeSvihIzdanjaSortiranihPoNazivuIliCeni);
		add(listanjeSamoOdredjenogTipaIzdanja);
		
		//Action listener za unos izdanja
		unosIzdanja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IzdanjeFrejm(listaIzdanja);
			}
		});
		
		//Action listener za unos pretplatnika
		unosPretplatnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PretplatnikFrejm(listaPretplatnika);
			}
		});
		
		//Action listener za unos pretplatnika
		unosPretplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PretplataFrejm(listaIzdanja, listaPretplatnika, listaPretplata);
			}
		});
		
		//Action listener za unos uplate
		unosUplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UplataFrejm(listaPretplatnika);
			}
		});
	}
	
	
	
	//SETERI
	public static void setListaIzdanja(ArrayList<Izdanje> listaIzdanja) {
		Frejm.listaIzdanja = listaIzdanja;
	}

	public static void setListaPretplatnika(ArrayList<Pretplatnik> listaPretplatnika) {
		Frejm.listaPretplatnika = listaPretplatnika;
	}

	public static void setListaPretplata(ArrayList<Pretplata> listaPretplata) {
		Frejm.listaPretplata = listaPretplata;
	}

}
