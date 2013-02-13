package knapsackj;

import java.util.ArrayList;

/**
 * A generic collection of items. Used for storing a data set.
 *
 * @author tcc10a
 */
public class ItemCollection {

    public ArrayList<Item> items;
    public int capacity;

    /**
     * Constructor.
     *
     * @param list An ArrayList of items to contain.
     * @param c The capacity used for this particular data set.
     */
    public ItemCollection(ArrayList<Item> list, int c) {
        items = list;
        capacity = c;
    }
}
