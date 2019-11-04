package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";
	private static Blogg samling;

	public static Blogg les(String filnavn) {

		File fil = new File(MAPPE + filnavn);

		try {
			Scanner les = new Scanner(fil);
			samling = new Blogg(Integer.parseInt(les.next()));

			while (les.hasNext()) {
				if (TEKST == les.next()) {
					les.next();
					Tekst tekst = new Tekst(Integer.parseInt(les.next()), les.next(), les.next(),
							Integer.parseInt(les.next()), les.next());
				}
				if (BILDE == les.next()) {
					les.next();
					Bilde bilde = new Bilde(Integer.parseInt(les.next()), les.next(), les.next(),
							Integer.parseInt(les.next()), les.next(), les.next());
				}
			}

			les.close();

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "FEIL: Filen finnes ikke.");
		}
		return samling;

	}
}
