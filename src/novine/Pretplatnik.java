package novine;

import java.io.Serializable;

public class Pretplatnik implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String ime;
	String prezime;
	String adresa;
	String brojTelefona;
	
	public Pretplatnik(String ime, String prezime, String adresa, String brojTelefona) {
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
	}
	
	
}
