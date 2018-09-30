package novine;

import java.io.Serializable;

public class Izdanje implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String imeIzdanja;
	String tipIzdanja;
	double cijenaPrimjerka;
	
	public Izdanje(String imeIzdanja, String tipIzdanja, double cijenaPrimjerka) {
		this.imeIzdanja = imeIzdanja;
		this.tipIzdanja = tipIzdanja;
		this.cijenaPrimjerka = cijenaPrimjerka;
	}
	
	
}
