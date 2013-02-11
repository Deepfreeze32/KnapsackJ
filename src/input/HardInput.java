package input;

import java.util.ArrayList;
import knapsackj.Item;
import knapsackj.ItemCollection;

/**
 * A default input class for KnapsackJ. Constructs a data set of 5 items.
 * @author tcc10a
 */
public class HardInput {
    private ArrayList<Item> items;
    
    /**
     * Default constructor. Builds a collection of items.
     */
    
    public HardInput() {
        items = new ArrayList<Item>(5);
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
        
        Item i1 = null;
        Item i2 = null;
        Item i3 = null;
        Item i4 = null;
        Item i5 = null;
        
        i1.value = v1;
        i1.weight = w1;
        i1.name = item1;
        
        i2.value = v2;
        i2.weight = w2;
        i2.name = item2;
        
        i3.value = v3;
        i3.weight = w3;
        i3.name = item3;

        i4.value = v4;
        i4.weight = w4;
        i4.name = item4;
        
        i5.value = v5;
        i5.weight = w5;
        i5.name = item5;
    }
    
    public ItemCollection getItems(){
        return new ItemCollection(items,13);
    }
}
