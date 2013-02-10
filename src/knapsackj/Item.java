/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsackj;

/**
 *
 * @author tcc10a
 */
public class Item implements Comparable<Item> 
{
    public int weight;
    public int value;
    
    public String name;
    
    public Item() {
        weight = 1;
        value = 0;
        name = null;
    }

    public Item(int wei, int val, String n) {
        if (weight > 0) 
        {
            weight = wei;
            value = val;
            name = n;
        } 
        else 
        {
            weight = 1;
            value = 0;
            name = null;
        }
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "/" + weight;
    }

    @Override
    public int compareTo(Item i) {
        return (int) Math.signum(weight * i.value - value * i.weight);
    }
}