package knapsackj;

import java.util.ArrayList;

/**
 * The Inventory class. Designates a configuration of a knapsack.
 *
 * @author Deepfreeze32
 */
public class Inventory {

    private ArrayList<Double> amounts;
    private Knapsack knapsack;
    private static final int NULL = -1;
    private double totalValue = NULL;

    /**
     * Normal constructor.
     *
     * @param backpack Knapsack to take from.
     * @param desiredAmounts Desired configuration.
     */
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

        if (amounts.size() < knapsack.size()) {
            for (int i = amounts.size(); i < knapsack.size(); i++) {
                amounts.add(0.0);
            }
        }
    }

    /**
     * Construct an inventory.
     *
     * @param backpack Knapsack to take from.
     * @param desiredAmounts Amounts to use.
     * @param val Value known.
     */
    public Inventory(Knapsack backpack, ArrayList<Double> desiredAmounts, double val) {
        //Invoke the other constructor.
        this(backpack, desiredAmounts);
        totalValue = val;
    }

    /**
     * Get the configuration of the Inventory.
     *
     * @return the configuration of the inventory.
     */
    public ArrayList<Double> getAmounts() {
        return new ArrayList<Double>(amounts);
    }

    /**
     * Get the total value of the Inventory.
     *
     * @return the value of the inventory.
     */
    public double getTotalValue() {
        if (totalValue == NULL) {
            return knapsack.getTotalValue(new ArrayList<Double>(amounts));
        } else {
            return totalValue;
        }
    }

    /**
     * Get the total value of the Inventory.
     *
     * @return the value of the inventory.
     */
    public double getTotalWeight() {
        return knapsack.getTotalWeight(new ArrayList<Double>(amounts));
    }

    /**
     * Stringify the Inventory.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return amounts.toString();
    }
}
