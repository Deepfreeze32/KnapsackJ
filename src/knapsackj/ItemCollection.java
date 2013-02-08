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
public class ItemCollection {
    public ArrayList<Item> items;
    public int capacity;
    
    public ItemCollection(ArrayList<Item> list,int c)
    {
        items = list;
        capacity = c;
    }
}
