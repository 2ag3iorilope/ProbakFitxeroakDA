package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class Aleatorio {
    public static void main(String[] args) {
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("amaiera")) {
                    break;
                }
                int randomNumber = random.nextInt(11);
                writer.println(randomNumber);
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
