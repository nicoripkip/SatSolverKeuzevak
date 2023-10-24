package SatSolverKeuzevak.solver;


import java.util.List;
import SatSolverKeuzevak.solver.Clause;


/**
 * 
 * 
 */
public class Main
{
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

                    break;
                    case "-f":

                    break;
                }

                i++;
            }
        }
    }


    /**
     * Funtie voor het uitrekenen
     * 
     */
    public static void CDCL()
    {

    }


    /**
     * Functie 
     * 
     * @param clauses
     */
    public static void DPLL(List<Clause> clauses)
    {

    }


    public static void unitPropagate()
    {

    }
}