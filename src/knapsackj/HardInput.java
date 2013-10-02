package knapsackj;

import java.util.ArrayList;
import knapsackj.Item;
import knapsackj.ItemCollection;

/**
 * A default input class for KnapsackJ. Constructs a data set of 5 items.
 *
 * @author Deepfreeze32
 */
public class HardInput {

    private ArrayList<Item> items;

    /**
     * Default constructor. Builds a collection of items.
     */
    public HardInput() {
        items = new ArrayList<Item>();
        String item1 = "A";
        String item2 = "B";
        String item3 = "C";
        String item4 = "D";
        String item5 = "E";

        int w1 = 5;
        int w2 = 6;
        int w3 = 2;
        int w4 = 10;
        int w5 = 9;

        int v1 = 3;
        int v2 = 2;
        int v3 = 9;
        int v4 = 1;
        int v5 = 18;

        Item i1 = new Item(w1, v1, item1);
        Item i2 = new Item(w2, v2, item2);
        Item i3 = new Item(w3, v3, item3);
        Item i4 = new Item(w4, v4, item4);
        Item i5 = new Item(w5, v5, item5);

        items = new ArrayList<Item>(5);
        items.add(i1);
        items.add(i2);
        items.add(i3);
        items.add(i4);
        items.add(i5);
        //System.out.println(items.toString());
    }

    public ItemCollection getItems() {
        return new ItemCollection(items, 20);
    }
}
