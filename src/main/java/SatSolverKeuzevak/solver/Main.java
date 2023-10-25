package SatSolverKeuzevak.solver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
                        
                        // Lees de inhoud van het DIMAC bestand
                        String contents = "";
                        System.out.println("path: " + BASE_PATH + args[i]);
                        try {
                            contents = readFile(BASE_PATH + args[i]);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                            System.exit(1);
                        }
                        
                        System.out.println(contents.charAt(0) == 'c');

                        // Verwijder de comments uit het DIMAC bestand
                        int pos = 0;
                        while (contents.charAt(pos) != 'p') {
                            pos++;
                        }
                        contents = contents.substring(pos, contents.length());

                        // Haal de indentificatie regel uit het bestand
                        pos = 0;
                        while (contents.charAt(pos) != '\n') {
                            pos++;
                        }
                        contents = contents.substring(pos+1, contents.length());


                        // Construct een lijst van clauses van het DIMAC bestand
                        String[] dimacClauses = contents.split("\n");

                        Set<Clause> clauses = new HashSet<Clause>();
                        for (String c : dimacClauses) {
                            c = c.substring(0, c.length()-2);
                            System.out.println(c);
                            ArrayList<String> n = new ArrayList<String>(Arrays.asList(c.split(" ")));

                            Set<Integer> in;
                            for (String l : n) {
                                in.add(Integer.parseInt(l));
                            }

                            Clause clause = new Clause();
                            clause.setLiterals(in);
                            clauses.add(clause);
                        }
                        
                        
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
                inputString.append(sc.nextLine() + "\n");
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


    /**
     * Functie om contents naar een file te schrijven
     * 
     * @param path
     * @return
     * @throws IOException
     */
    public static Boolean writeFile(String path) throws IOException
    {
        return false;
    }
}