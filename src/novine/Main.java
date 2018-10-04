package novine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) {
		
		//Deklaracija i inicijalizacija fajlova potrebnih za cuvanje podataka
		File fileIzdanja = new File("Izdanja.txt");
		File filePretplatnici = new File("Pretplatnici.txt");
		File filePretplate = new File("Pretplate.txt");
		
		
		//Provjera da li fajlovi vec postoje i njihovo kreiranje ukoliko ne postoje
		provjeraIKreiranjeFajla(fileIzdanja);
		provjeraIKreiranjeFajla(filePretplatnici);
		provjeraIKreiranjeFajla(filePretplate);

		
		//Deklaracija i inicijalizacija array lista u kojima su smjesteni svi potrebni podaci
		ArrayList<Izdanje> listaIzdanja = new ArrayList<>();
		ArrayList<Pretplatnik> listaPretplatnika = new ArrayList<>();
		ArrayList<Pretplata> listaPretplata = new ArrayList<>();
		
		
		//Deklaracija i inicijalizacija ObjectInputStream-a, i ucitavanje objekata if file-ova
		ObjectInputStream oisIzdanje = null;
		ObjectInputStream oisPretplatnik = null;
		ObjectInputStream oisPretplata = null;
		try {
			oisIzdanje = new ObjectInputStream(new FileInputStream(fileIzdanja));
			Izdanje i = null;
			while ((i = (Izdanje) oisIzdanje.readObject()) != null){
				listaIzdanja.add(i);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			System.out.println("Nije pronadjena klasa!");
		}
		try {
			oisPretplatnik = new ObjectInputStream(new FileInputStream(filePretplatnici));
			Pretplatnik p1 = null;
			while ((p1 = (Pretplatnik) oisPretplatnik.readObject()) != null){
				listaPretplatnika.add(p1);
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			System.out.println("Nije pronadjena klasa!");
		}
		try {
			oisPretplata = new ObjectInputStream(new FileInputStream(filePretplate));
			Pretplata p2 = null;
			while ((p2 = (Pretplata) oisPretplata.readObject()) != null){
				listaPretplata.add(p2);
			}
		} catch (IOException e) {
			System.out.println("Greska prilikom instanciranja ObjectInputStream-a!");
		} catch (ClassNotFoundException e) {
			System.out.println("Nije pronadjena klasa!");
		}
		//Zatvaranje ois objekata
		try {
			oisIzdanje.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oisPretplatnik.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oisPretplata.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//GUI
		new Frejm(listaIzdanja, listaPretplatnika, listaPretplata);
		
	}


	private static void provjeraIKreiranjeFajla(File f) {
		if(! f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				System.out.println("Fajl se ne moze kreirati!");
			}
		}
	}
	
	
}
