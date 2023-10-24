package SatSolverKeuzevak.solver;

import java.util.ArrayList;


/**
 * 
 * 
 */
public class Clause 
{
    private ArrayList<Integer> _literals;


    /**
     * Constructor
     * 
     */
    public Clause()
    {

    }


    /**
     * Print information of the clause
     * 
     * 
     */
    public void print()
    {
        System.out.println("Jeg er en Clause");
    }


    /**
     * Functie om the literals van de clause te zetten
     * 
     * @param literals
     */
    public void setLiterals(ArrayList<Integer> literals)
    {
        this._literals = literals;
    }


    /**
     * Functie om de literals van de clause op te halen
     * 
     * @return
     */
    public ArrayList<Integer> getLiterals()
    {
        return this._literals;
    }
}
