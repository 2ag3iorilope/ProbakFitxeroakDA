package Fitxategiak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ComunicationBetweenProcess2 {

	public static void main(String[] args) throws IOException {
		// Runtime bidez gure prozesua exekutatu
		Process process = Runtime.getRuntime().exec(args);

		// Gauzatzen ari den prozesuaren sarrera-fluxua lortzen du
		InputStream is = process.getInputStream();

		// Karaktere-irakurgailu bat sortzen du sarrera-fluxutik abiatuta
		InputStreamReader isr = new InputStreamReader(is);

		// Bildu karaktere-irakurgailua BufferedReader batean, testu-lerroak irakurri
		// ahal izateko
		BufferedReader br = new BufferedReader(isr);

		String line;
		System.out.printf(Arrays.toString(args) + " prozesuaren emaitza:\n");

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		try {
		
			process.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//[notepad.exe, calc.exe, cmd.exe] prozesuaren emaitza: