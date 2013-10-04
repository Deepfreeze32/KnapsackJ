package knapsackj;

/**
 * KnapsackJ, the main class. Home of the infamous main function.
 *
 * @author Deepfreeze32
 */
public class KnapsackJ {

    /**
     * Command line args will eventually control solution types.
     * <p>
     * As it stands, to add or remove solve types, add appropriate logic.
     * <p>
     * Example: System.out.println("Exhaustive solution:");
     *          ks.solveExhaustively();
     * <p>
     * Exhaustive solution not used because a complete evaluation of a large dataset is 
     * very time consuming.
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

        KnapsackSolver ks = new KnapsackSolver(items);
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
