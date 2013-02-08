/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackj;

import java.util.ArrayList;

/**
 * The actual Knapsack.
 * @author tcc10a
 */
public class Knapsack {
    private ArrayList<Item> items;
    private int capacity;
    
    public Knapsack(ItemCollection ic) {
        items = ic.items;
        capacity = ic.capacity;
    }
    
    public Knapsack(int newCap, Knapsack old) {
        items = old.items;
        capacity = newCap;
    }
    
    
}
