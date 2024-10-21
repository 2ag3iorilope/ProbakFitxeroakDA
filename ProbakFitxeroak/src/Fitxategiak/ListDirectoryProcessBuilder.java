package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ListDirectoryProcessBuilder {

    public static void main(String[] args) {

        try {
            // Erabiltzailearen sarrera harrapatzeko Scanner bat sortu
            Scanner scanner = new Scanner(System.in);
            System.out.print("Sartu direktorioaren bidea: "); // Erabiltzailearentzako mezua

            // Erabiltzaileak sartutako direktorioa irakurri
            String directoryPath = scanner.nextLine();

            // Sartutako direktorioarekin ProcessBuilder sortu
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "dir \"" + directoryPath + "\"");
            builder.redirectErrorStream(true); // Irteera akatsen irteera estandarrera birbideratu

            // Prozesua hasi
            Process process = builder.start();

            // Prozesuaren irteera irakurri
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Irteerako lerro bakoitza inprimatu
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Scanner-a itxi
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace(); // Salbuespen bat gertatuz gero, errorearen trazaren inprimaketa
        }

    }
}
