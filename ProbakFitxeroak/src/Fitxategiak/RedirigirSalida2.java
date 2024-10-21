package Fitxategiak;

import java.io.*;

public class RedirigirSalida2 {

	public static void main(String[] args) {

		try {

			// Prozesu semea sortu

			//ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ipconfig");
			
			//Gaizki konprobatzeko
			 ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "unaiiii");


			// Prozesu semearen irteera artxibo batera birbideratzea

			pb.redirectOutput(new File("salida.txt"));

			// Prozesua hasi

			Process proceso = pb.start();

			// Prozesua amaitu arte itxaron

			int exitCode = proceso.waitFor();

			System.out.println("Prozesua kode honekin amaitu da: " + exitCode);

		} catch (IOException | InterruptedException e) {

			e.printStackTrace();

		}

	}

}
//Programak komando bat exekutatzen du Windowseko komando-lerroan (cmd), eta irteera berriz 
//bideratzen du salida.txt izeneko fitxategi batera.

//Gainera beste adibideak ez du errore kontrola
