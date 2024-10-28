package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Maiuskulak {
    
    public static void main(String[] args) {
        try {
            // Iniciar el proceso hijo
            ProcessBuilder builder = new ProcessBuilder("java", "ProcesoHijo");
            Process process = builder.start();

            // Streams para la comunicación
            OutputStream os = process.getOutputStream();
            PrintWriter writer = new PrintWriter(os);
            InputStream is = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            // Leer la entrada estándar del usuario y enviarla al proceso hijo
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String inputLine;

            System.out.println("Introduce texto (escribe 'salir' para terminar):");

            while (!(inputLine = stdIn.readLine()).equalsIgnoreCase("salir")) {
                // Enviar entrada al proceso hijo
                writer.println(inputLine);
                writer.flush(); // Asegurarse de que se envíe inmediatamente

                // Leer la respuesta del proceso hijo
                String response = reader.readLine();
                System.out.println("Desde hijo: " + response);
            }

            // Cerrar recursos
            writer.close();
            reader.close();
            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
