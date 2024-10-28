package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ListDirectoryRuntime {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Sartu direktorioa argudio bezela.");
            return;
        }

        String directory = args[0];

        try {

            Process process = Runtime.getRuntime().exec("cmd.exe /c dir " + directory);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
//Programak gure diretorioko fitxategiak eta direktorioak erakusten ditu