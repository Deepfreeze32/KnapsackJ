package knapsackj;

import input.HardInput;

/**
 * KnapsackJ, the main class. Home of the infamous main function.
 * @author tcc10a
 */
public class KnapsackJ {

    /**
     * Main. Duh. Command line args will eventually control data sets.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HardInput in = new HardInput();
        ItemCollection items = in.getItems();
        //System.out.println(items.toString());
        Knapsack k = new Knapsack(items);
        //System.out.println(k.toString());
        Inventory i = k.solveDynamically();
        System.out.println(i.toString());
    }
}
