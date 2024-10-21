package Fitxategiak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * Prozesuen arteko komunikazioa kudeatzen duen klasea.
 */
public class ComunicationBetweenProcess {

	/**
	 * Main metodoa.
	 *
	 * @param args argumentuak
	 * @throws IOException I/O salbuespen bat gertatu dela adierazten du.
	 */
	public static void main(String[] args) throws IOException {
		Process process = new ProcessBuilder(args).start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		System.out.println("Exekutatzeko errorea %s da:" + Arrays.toString(args) + ".");

		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
