package knapsackj;

import java.util.ArrayList;

/**
 * A simple facade class for KnapsackJ.
 * @author tcc10a
 */
public class KnapsackSolver 
{
    private Knapsack knapsack;
    public KnapsackSolver(ItemCollection items)
    {
        knapsack = new Knapsack(items);
    }
    
    private ArrayList<Item> convertSolution(ArrayList<Double> amounts)
    {
        ArrayList<Item> best = new ArrayList<Item>();
        for (int i = 0; i < knapsack.items.size(); i++) 
        {
            if (amounts.get(i).doubleValue() == 1.0) 
            {
                best.add(knapsack.items.get(i));
            }
        }
        return best;
    }
    
    public void solveExhaustively()
    {
        Inventory ex = knapsack.solveExhaustively();
        ArrayList<Double> amounts = ex.getAmounts();
        ArrayList<Item> best = convertSolution(amounts);
        System.out.println("Value: "+ex.getTotalValue()+" Items: "+best.toString());
    }
    
    public void solveDynamically()
    {
        Inventory dy = knapsack.solveDynamically();
        ArrayList<Double> amounts = dy.getAmounts();
        ArrayList<Item> best = convertSolution(amounts);
        System.out.println("Value: "+dy.getTotalValue()+" Items: "+best.toString());
    }
    
    public void solveGreedily()
    {
        Inventory gr = knapsack.solveGreedily();
        ArrayList<Double> amounts = gr.getAmounts();
        ArrayList<Item> best = convertSolution(amounts);
        System.out.println("Value: "+gr.getTotalValue()+" Items: "+best.toString());
    }
    
    public void solveFractionally()
    {
        Inventory fr = knapsack.solveFractional();
        ArrayList<Double> amounts = fr.getAmounts();
        ArrayList<Item> best = convertSolution(amounts);
        System.out.println("Value: "+fr.getTotalValue()+" Items: "+best.toString());
    }
}
