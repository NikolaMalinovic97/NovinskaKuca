package novine;

import java.io.Serializable;

public class Pretplata implements Serializable {

	private static final long serialVersionUID = 1L;

	Pretplatnik pretplatnik;
	Izdanje izdanje;
	int godinaPretplate;
	int brojNarucenihPrimjeraka;
	
	public Pretplata(Pretplatnik pretplatnik, Izdanje izdanje, int godinaPretplate, int brojNarucenihPrimjeraka) {
		super();
		this.pretplatnik = pretplatnik;
		this.izdanje = izdanje;
		this.godinaPretplate = godinaPretplate;
		this.brojNarucenihPrimjeraka = brojNarucenihPrimjeraka;
	}
	
	
}
