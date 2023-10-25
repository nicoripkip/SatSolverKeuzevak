package SatSolverKeuzevak.solver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

import SatSolverKeuzevak.solver.Clause;


/**
 * 
 * 
 */
public class Main
{
    private static final String BASE_PATH = System.getProperty("user.dir");


    /**
     * Main function
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i])
                {
                    case "-i":
                        i++;
                        System.out.println("Denne funktion: -i arbejdede");
                        System.out.println("");
                        
                        String contents = "";
                        System.out.println("path: " + BASE_PATH + args[i]);
                        try {
                            contents = readFile(BASE_PATH + args[i]);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                            System.exit(1);
                        }
                        
                        System.out.println(contents);
                    break;
                    case "-f":
                        i++;
                        System.out.println("Denne funktion: -f arbejdede");
                        System.out.println("Filename: " + args[i]);
                    break;
                    default:
                        System.out.println("[error]\tKan ikke finde din kommando!");
                        System.exit(1);
                }
            }
        }
    }


    /**
     * Functie om de contents van een bestand te lezen
     * 
     * @param path
     * @return
     */
    public static String readFile(String path) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(path);
        Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8);
        StringBuilder inputString = new StringBuilder();

        try {
            while (sc.hasNextLine()) {
                inputString.append(sc.nextLine());
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (sc != null) {
                sc.close();
            }
        }

        return inputString.toString();
    }
}