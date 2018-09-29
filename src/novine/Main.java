package novine;

import java.io.File;
import java.io.IOException;
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
		
		//Ucitavanje podataka iz fajlova u liste
		
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
