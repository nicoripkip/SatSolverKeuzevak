package SatSolverKeuzevak.solver;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import SatSolverKeuzevak.solver.Clause;


/**
 * 
 * https://en.wikipedia.org/wiki/DPLL_algorithm
 * 
 */
public class DPLL
{
    private Set<Clause>     _clauses;
    private Set<Integer>    _Model;


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
     * Functie om het algoritme uit te voeren
     * 
     * @param phi
     * @return
     */
    public Boolean run(Set<Clause> phi)
    {
        while (this.containsUnitClause(phi)) {
            int literal = getUnitLiteral(phi);
            phi = this.unitPropagate(literal, phi);
        }

        while (this.containsPureLiteral(phi)) {
            int literal = 0;
            phi = this.pureLiteralAssign(literal, phi);
        }

        if (phi.isEmpty()) {
            return true;
        }

        if (this.containsEmptyClause(phi)) {
            return false;
        }   

        int literal = this.chooseLiteral(phi);
        Set<Clause> phi_p = phi;

        phi.addAll(literal);

        phi_p.addAll();

        // https://en.wikipedia.org/wiki/Short-circuit_evaluation
        return this.run(phi) || this.run(phi_p);
    }


    /**
     * Functie om unit clauses te verwijderen uit de lijst met clauses
     * https://en.wikipedia.org/wiki/Unit_propagation
     * 
     * @param literal
     * @param phi
     * @return
     */
    private Set<Clause> unitPropagate(int literal, Set<Clause> phi)
    {
        Set<Clause> phi_p = new HashSet<Clause>();

        for (Clause x : phi) {
            Set<Integer> nLiterals = new HashSet<Integer>();
            Boolean literalFound = false;
            
            for (int l : x.getLiterals()) {
                if (l == literal) {
                    literalFound = true;
                    break;
                }

                if (l != -literal) {
                    nLiterals.add(l);
                }
            }

            if (!literalFound) {
                Clause clause = new Clause();
                clause.setLiterals(nLiterals);
                phi_p.add(clause);
            }
        }

        return phi_p;
    }


    /**
     * Functie om elke pure literal uit de lijst met clauses te halen
     * 
     * @param literal
     * @param phi
     * @return
     */
    private Set<Clause> pureLiteralAssign(int literal, Set<Clause> phi)
    {
        return new HashSet<Clause>();
    }


    /**
     * Functie dat kijkt of er unit clauses aanwezig zijn in de lijst met clauses
     * 
     * @param clauses
     * @return
     */
    private Boolean containsUnitClause(Set<Clause> phi)
    {
        for (Clause x : phi) {
            if (x.getLiterals().size() == 1) {
                return true;
            }
        }

        return false;
    }


    /**
     * Functie om te checken of een literal pure is ja of te nee
     * 
     * @param phi
     * @return
     */
    private Boolean containsPureLiteral(Set<Clause> phi)
    {
        return false;
    }


    /**
     * Functie om te checken of een clause leeg is ja of te nee
     * 
     * @param phi
     * @return
     */
    private Boolean containsEmptyClause(Set<Clause> phi)
    {
        for (Clause x : phi) {
            if (x.getLiterals().size() == 0) {
                return true;
            }
        }

        return false;
    }


    /**
     * Functie om een literal uit lijst phi te kiezen
     * 
     * @param phi
     * @return
     */
    private int chooseLiteral(Set<Clause> phi)
    {
        return phi.iterator()
                  .next()
                  .getLiterals()
                  .iterator()
                  .next();
    }


    /**
     * Functie om de unit literal te vinden
     * 
     * @param phi
     */
    private int getUnitLiteral(Set<Clause> phi)
    {
        for (Clause x : phi) {
            if (x.getLiterals().size() == 1) {
                return x.getLiterals()
                        .iterator()
                        .next();
            }
        }

        return 0;
    }
}