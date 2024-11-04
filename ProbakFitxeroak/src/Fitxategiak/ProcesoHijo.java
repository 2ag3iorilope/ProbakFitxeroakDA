package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcesoHijo {
    public static void main(String[] args) {
        try {
      
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = reader.readLine()) != null) {
             
                System.out.println(line.toUpperCase());
                System.out.flush(); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
