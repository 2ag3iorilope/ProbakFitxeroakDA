package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Semeprozesua {
    public static void main(String[] args) {
        try {
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = reader.readLine()) != null) {
                // maiuskulan bihurtu
                System.out.println(line.toUpperCase());
                System.out.flush(); // bidali erantzuna
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
