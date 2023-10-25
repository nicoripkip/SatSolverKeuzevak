package SatSolverKeuzevak.solver;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    public DPLL()
    {

    }


    /**
     * 
     * 
     * @return
     */
    public Boolean run(Set<Clause> phi)
    {
        while (this.containsUnitClause(phi)) {

        }

        while (this.containsPureLiteral(phi)) {

        }

        if (phi.isEmpty()) {
            return true;
        }

        if (this.containsEmptyClause(phi)) {

        }

        // https://en.wikipedia.org/wiki/Short-circuit_evaluation
        // return this.run() || this.run();
        return false;
    }


    /**
     * Functie om unit clauses te verwijderen uit de lijst met clauses
     * https://en.wikipedia.org/wiki/Unit_propagation
     * 
     * @return
     */
    private Set<Clause> unitPropagate()
    {
        return new HashSet<Clause>();
    }


    /**
     * Functie om elke pure literal uit de lijst met clauses te halen
     * 
     * @return
     */
    private Set<Clause> pureLiteralElimination()
    {
        return new HashSet<Clause>();
    }


    /**
     * Functie dat kijkt of er unit clauses aanwezig zijn in de lijst met clauses
     * 
     * @param clauses
     * @return
     */
    private Boolean containsUnitClause(Set<Clause> clauses)
    {
        return false;
    }


    private Boolean containsPureLiteral(Set<Clause> clauses)
    {
        return false;
    }


    private Boolean containsEmptyClause(Set<Clause> clauses)
    {
        return false;
    }
}