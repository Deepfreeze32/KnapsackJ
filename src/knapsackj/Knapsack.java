/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The actual Knapsack.
 *
 * @author tcc10a
 */
public class Knapsack 
{
    private ArrayList<Item> items;
    private int capacity;


    public Knapsack() 
    {
        capacity = 1;
        items = new ArrayList<Item>();
    }

    public Knapsack(int size, List<Item> itemList) 
    {
        capacity = size;
        items = new ArrayList<Item>(itemList);
        Collections.sort(items);
    }

    public Knapsack(int newSize, Knapsack knapsack) 
    {
        capacity = newSize;
        items = knapsack.items;
    }

    public int size() 
    {
        return items.size();
    }

    @Override
    public String toString() 
    {
        return capacity + ": " + items;
    }

    public double getTotalValue(ArrayList<Double> amounts) 
    {
        double total = 0;
        if (amounts.size() < items.size()) 
        {
            for (int i = amounts.size(); i < items.size(); i++) 
            {
                amounts.add(0.0);
            }
        }
        for (int i = 0; i < amounts.size(); i++) 
        {
            total += amounts.get(i) * items.get(i).getValue();
        }
        return total;
    }

    public Inventory solveFractional() 
    {
        int availableCapacity = capacity;
        ArrayList<Double> amounts = new ArrayList<Double>();
        if (availableCapacity <= 0) 
        {
            return new Inventory(this, amounts);
        }
        for (Item i : items) 
        {
            if (availableCapacity < i.getWeight()) 
            {
                amounts.add(((double) availableCapacity) / i.getWeight());
                return new Inventory(this, amounts);
            }
            availableCapacity -= i.getWeight();
            amounts.add(1.0);
        }
        return new Inventory(this, amounts);
    }

    public Inventory solveGreedily() 
    {
        int availableCapacity = capacity;
        ArrayList<Double> amounts = new ArrayList<Double>();
        if (availableCapacity <= 0) 
        {
            return new Inventory(this, amounts);
        }
        for (Item i : items) 
        {
            if (availableCapacity < i.getWeight()) 
            {
                amounts.add(0.0);
            } 
            else 
            {
                availableCapacity -= i.getWeight();
                amounts.add(1.0);
            }
        }
        return new Inventory(this, amounts);
    }

    public Inventory solveDynamically() 
    {
        int[] solution = new int[capacity + 1];
        ArrayList<Double> amounts = new ArrayList<Double>();
        boolean[][] isIncluded = new boolean[items.size()][capacity + 1];

        if (capacity < 0) 
        {
            return new Inventory(this, amounts);
        }

        // build the tables  
        for (int i = 0; i < items.size(); i++) 
        {
            amounts.add(0.0);
            Item item = items.get(i);
            int benefit = item.getValue();
            int weight = item.getWeight();
            for (int c = capacity; c >= weight; c--) 
            {
                int newBenefit = benefit + solution[c - weight];
                if (newBenefit > solution[c]) 
                {
                    isIncluded[i][c] = true;
                    solution[c] = newBenefit;
                }
            }
        }

        // construct the solution  
        int c = capacity;
        int p = 0;
        for (int i = items.size() - 1; i >= 0; i--) 
        {
            boolean b = isIncluded[i][c];
            if (b) 
            {
                c -= items.get(i).getWeight();
                p += items.get(i).getValue();
                amounts.set(i, 1.0);
            }
        }
        return new Inventory(this, amounts);
    }

    public Inventory solveExhaustively() 
    {
        int availableCapacity = capacity;
        return solveExhaustivelyRecursively(0, capacity, new ArrayList<Double>(), 0);
    }

    private Inventory solveExhaustivelyRecursively(int nextItemIndex, int availableCapacity, ArrayList<Double> result, int value) 
    {
        if (nextItemIndex >= items.size()) 
        {
            return new Inventory(this, result, value);
        }
        Item nextItem = items.get(nextItemIndex);

        result.add(0.0);
        Inventory resultAfterExclusion = solveExhaustivelyRecursively(nextItemIndex + 1, availableCapacity, result, value);
    
        if (nextItem.getWeight() > availableCapacity) 
        {
            result.remove(result.size() - 1);
            return resultAfterExclusion;
        } 
        else 
        {
            result.set(result.size() - 1, 1.0);
            Inventory resultAfterInclusion = solveExhaustivelyRecursively(nextItemIndex + 1,availableCapacity - nextItem.getWeight(),result, value + nextItem.getValue());
            result.remove(result.size() - 1);
            if (resultAfterInclusion.getTotalValue() >= resultAfterExclusion.getTotalValue()) 
            {
                return resultAfterInclusion;
            } 
            else 
            {
                return resultAfterExclusion;
            }
        }
    }
}
