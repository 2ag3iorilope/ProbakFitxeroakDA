package Fitxategiak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejecuta {

	public static void main(String[] args) throws IOException {

		// Konprobatu argumentuak sartu dituen
		if (args.length <= 0) {
			System.err.println("Komando bat behar duzu argumentuetan");
			System.exit(-1);
		}

		Runtime runtime = Runtime.getRuntime();

		Process process = runtime.exec(args);

		// Erroreak lortu
		BufferedReader berr = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		// Idatzi errorea fitxategian
		try (FileWriter fileWriter = new FileWriter("errore.txt")) {

			String line;

			// Erakutsi sartutako argumentuen komandoa
			System.out.println("Errorea exekutatzerakoan " + Arrays.toString(args) + " da:");

			while ((line = berr.readLine()) != null) {
				fileWriter.write(line + System.lineSeparator());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Erakutsi errorea.txt fitxategiaren edukia
		System.out.println("\nErrore.txt ko edukia:");
		try (BufferedReader fileReader = new BufferedReader(new FileReader("errore.txt"))) {

			String line;
			while ((line = fileReader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
