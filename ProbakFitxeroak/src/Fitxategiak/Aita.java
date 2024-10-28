package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aita {
	public static void main(String[] args) {
		try {
			// Semearen exekutablearen ruta osoa
			String childJarPath = "C:\\Users\\2ag3.iorilope\\Desktop\\aleatorio.jar";

			// Exekutatu fitxaetgia
			Process process = Runtime.getRuntime().exec("java -jar \"" + childJarPath + "\"");

			BufferedReader childOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			PrintWriter childInput = new PrintWriter(new OutputStreamWriter(process.getOutputStream()), true);

			Scanner scanner = new Scanner(System.in);
			String input;

			System.out.println("Zerbait idatzi ausazko zenbaki bat eskatzeko 'amaiera' amaitzeko:");

			while (!(input = scanner.nextLine()).equalsIgnoreCase("amaiera")) {
				childInput.println("sortu");
				childInput.flush();

				// Irakurri eta erakutsi ausazko zenbakia
				String randomNumber = childOutput.readLine();
				if (randomNumber != null) {
					System.out.println("Lortutako ausazko zenbakia: " + randomNumber);
				}
			}

			childInput.println("amaiera");
			childInput.flush();
			process.waitFor();

			System.out.println("Prozesua amaitu da.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
