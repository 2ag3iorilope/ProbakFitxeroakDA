package Fitxategiak;

import java.io.*;

public class RedirigirSalida {

    public static void main(String[] args) {

        try {
            // Prozesu semea sortu
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "ipconfig");

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

//Adibide honekin gure erantzuna fitxatgi batean aurkitu dezakegu, hau da ez dugu kontsolan irakurriko