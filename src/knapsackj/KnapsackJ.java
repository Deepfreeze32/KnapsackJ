package knapsackj;

import input.HardInput;

/**
 * KnapsackJ, the main class. Home of the infamous main function.
 * @author tcc10a
 */
public class KnapsackJ 
{

    /**
     * Main. Duh. Command line args will eventually control data sets.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        HardInput in = new HardInput();
        ItemCollection items = in.getItems();
        //System.out.println(items.toString());
        KnapsackSolver ks = new KnapsackSolver(items);
        System.out.println("Exhaustive solution:");
        ks.solveExhaustively();
        System.out.println("Dynamic solution:");
        ks.solveDynamically();
        System.out.println("Greedy solution:");
        ks.solveGreedily();
        System.out.println("Fractional solution:");
        ks.solveFractionally();
    }
}
