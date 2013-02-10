/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackj;

import java.util.ArrayList;

/**
 *
 * @author tcc10a
 */
public class Inventory 
{
    private ArrayList<Double> amounts;
    private Knapsack knapsack;
    private static final int NULL = -1;
    private double totalValue = NULL;

    @SuppressWarnings("UnusedAssignment")
    public Inventory(Knapsack backpack, ArrayList<Double> desiredAmounts) {
        if (backpack == null) {
            backpack = new Knapsack();
        } else {
            knapsack = backpack;
        }
        if (desiredAmounts == null) {
            amounts = new ArrayList<Double>();
        } else {
            amounts = new ArrayList<Double>(desiredAmounts);
        }
        if (amounts.size() < knapsack.size()) 
        {
            for (int i = amounts.size(); i < knapsack.size(); i++) 
            {
                amounts.add(0.0);
            }
        }
    }

    public Inventory(Knapsack backpack, ArrayList<Double> desiredAmounts, double benefit) {
        this(backpack, desiredAmounts);
        totalValue = benefit;
    }

    public ArrayList<Double> getAmounts() {
        return new ArrayList<Double>(amounts);
    }

    public double getTotalValue() {
        if (totalValue == NULL) {
            return knapsack.getTotalValue(new ArrayList<Double>(amounts));
        } else {
            return totalValue;
        }
    }

    /**
     * Returns a string representing the list of amounts of each item in the
     * packing
     *
     * @return the string
     */
    @Override
    public String toString() {
        return amounts.toString();
    }
}
