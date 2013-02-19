package knapsackj;

/**
 * KnapsackJ, the main class. Home of the infamous main function.
 *
 * @author tcc10a
 */
public class KnapsackJ {

    /**
     * Main. Duh. Command line args will eventually control data sets.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ItemCollection items = null;
        if (args.length == 0) {
            HardInput in = new HardInput();
            items = in.getItems();
        } else {
            CSVParser csv = new CSVParser(args[0]);
            items = csv.parse();
        }

        //System.out.println(items.toString());
        KnapsackSolver ks = new KnapsackSolver(items);
        //System.out.println("Exhaustive solution:");
        //ks.solveExhaustively();
        System.out.println("Smart solution:");
        ks.solveSmartly();
        System.out.println("Dynamic solution:");
        ks.solveDynamically();
        System.out.println("Greedy solution:");
        ks.solveGreedily();
        System.out.println("Fractional solution:");
        ks.solveFractionally();
    }
}
