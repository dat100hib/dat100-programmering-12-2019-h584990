package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	// TODO: objektvariable
	private Innlegg[] innleggTab;
	private int nesteLedig;

	public Blogg() {
		nesteLedig = 0;
		innleggTab = new Innlegg[20];
	}

	public Blogg(int lengde) {
		nesteLedig = 0;
		innleggTab = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteLedig;
	}

	public Innlegg[] getSamling() {
		return innleggTab;
	}

	public int finnInnlegg(Innlegg innlegg) {
//		boolean funnet = false;
//		int pos = 0;
//		while (pos < nesteLedig && !funnet) {
//			
//			if (innlegg.getId() == innleggTab[pos].getId()) {
//				funnet = true;
//			}
//			pos++;
//		}
//		return pos;
		
		for (int i = 0; i < nesteLedig; i++) {
			if (innlegg.erLik(innleggTab[i])) {
				return i;
			}
		}
		return -1;
		
//		int index = -1;
//		int i = 0;
//		while (i < nesteLedig && index < 0) {
//			if (innleggTab[i].erLik(innlegg)) {
//				index = 1;
//			} else {
//				i++;
//			}
//		}
//		return index;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false;
		int i = 0;
		while (i < nesteLedig && !funnet) {
			if (innlegg.getId() == innleggTab[i].getId()) {
				funnet = true;
			}
			i++;
		}
		return funnet;
//		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
    	boolean ledig = true;
//		int i = 0;
//		while (i < innleggTab.length && !ledig) {
//			if (innleggTab[i] == null) {
//				ledig = true;
//			}
//			i++;
//		}
//		return ledig;
		
		if(nesteLedig == innleggTab.length) {
			ledig = false;
		}
		return ledig;
			
	}

	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		if (!finnes(innlegg)) {
			innleggTab[nesteLedig] = innlegg;
			lagtTil = true;
			nesteLedig++;
		}
		return lagtTil;
	}

	public String toString() {
		String a = "";
		for (int i = 0; i < nesteLedig; i++) {
			a += innleggTab[i].toString();
		}
		return nesteLedig + "\n" + a;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nyTab = new Innlegg[2 * innleggTab.length];
		for (int i = 0; i < innleggTab.length; i++) {
			nyTab[i] = innleggTab[i];
		}
		innleggTab = nyTab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			if (ledigPlass()) {
				leggTil(innlegg);
				return true;
			} else {
				utvid();
				leggTil(innlegg);
				return true;
			}
		}
		return false;
	}

	public boolean slett(Innlegg innlegg) {
		int pos;
		pos = finnInnlegg(innlegg);
		
		if (pos != -1) {
			while (pos < nesteLedig - 1) {
				innleggTab[pos] = innleggTab[pos + 1];
				pos++;
			}
			nesteLedig--;
			return true;
		} else {
			return false;
		}
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}