package Fitxategiak;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Maiuskulak {
    
	
	    
	    public static void main(String[] args) {
	        try {
	            // Seme prozesua ahsi
	            ProcessBuilder builder = new ProcessBuilder("java", "-jar", "C:\\Users\\2ag3.iorilope\\.m2\\repository\\com\\mycompany\\SemeProzesua\\1.0-SNAPSHOT\\SemeProzesua-1.0-SNAPSHOT.jar");
	            builder.redirectErrorStream(true); 
	            Process process = builder.start();

	         
	            OutputStream os = process.getOutputStream();
	            PrintWriter writer = new PrintWriter(os, true);
	            InputStream is = process.getInputStream();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

	            // Leer la entrada estándar del usuario y enviarla al proceso hijo
	            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	            String inputLine;

	            System.out.println("Sartu testua (idatzi 'irten' programa amaitzeko):");

	            while (!(inputLine = stdIn.readLine()).equalsIgnoreCase("irten")) {
	               
	                writer.println(inputLine);

	                //Irakurri erantzuna
	                String response = reader.readLine();
	                if (response != null) {
	                    System.out.println("Semeak esaten du:: " + response);
	                } else {
	                    System.out.println("Ez da lortu erantzunikan.");
	                }
	            }

	        
	            writer.close();
	            reader.close();
	            process.waitFor();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	}

