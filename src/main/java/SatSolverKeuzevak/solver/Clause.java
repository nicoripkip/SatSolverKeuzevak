package SatSolverKeuzevak.solver;


import java.util.Set;


/**
 * 
 * 
 */
public class Clause 
{
    private Set<Integer> _literals;


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
    public void setLiterals(Set<Integer> literals)
    {
        this._literals = literals;
    }


    /**
     * Functie om de literals van de clause op te halen
     * 
     * @return
     */
    public Set<Integer> getLiterals()
    {
        return this._literals;
    }
}
