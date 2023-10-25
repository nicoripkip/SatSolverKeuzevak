package SatSolverKeuzevak.solver;


import java.util.ArrayList;
import java.util.List;


/**
 * 
 * https://en.wikipedia.org/wiki/DPLL_algorithm
 * 
 */
public class DPLL
{
    private List<Clause>        _clauses;
    private ArrayList<Integer>  _Model;


    /**
     * Constructor
     * 
     * @param clauses
     * @param Model
     */
    public DPLL(List<Clause> clauses, ArrayList<Integer> Model)
    {

    }


    /**
     * 
     * 
     * @return
     */
    public Boolean run()
    {
        while (this.containsUnitClause(this._clauses)) {

        }

        // https://en.wikipedia.org/wiki/Short-circuit_evaluation
        return this.run() || this.run();
    }


    /**
     * Functie om unit clauses te verwijderen uit de lijst met clauses
     * https://en.wikipedia.org/wiki/Unit_propagation
     * 
     * @return
     */
    private List<Clause> unitPropagate()
    {
        return new ArrayList<Clause>();
    }


    /**
     * Functie om elke pure literal uit de lijst met clauses te halen
     * 
     * @return
     */
    private List<Clause> pureLiteralElimination()
    {
        return new ArrayList<Clause>();
    }


    /**
     * Functie dat kijkt of er unit clauses aanwezig zijn in de lijst met clauses
     * 
     * @param clauses
     * @return
     */
    private Boolean containsUnitClause(List<Clause> clauses)
    {
        return false;
    }
}