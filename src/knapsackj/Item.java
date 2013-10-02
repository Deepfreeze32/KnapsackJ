package knapsackj;

/**
 * The Item class for KnapsackJ. Implements Comparable so that a collection of
 * items may be sorted.
 *
 * @author Deepfreeze32
 */
public class Item implements Comparable<Item> {

    public int weight;
    public int value;
    public String name;

    /**
     * Default constructor. Sets weight to 1, value to 0, name to null.
     */
    public Item() {
        weight = 1;
        value = 0;
        name = null;
    }

    /**
     *
     * @param wei the weight to set for this new item
     * @param val the value to set for this new item
     * @param n the name of this item.
     */
    public Item(int wei, int val, String n) {
        if (wei > 0) {
            weight = wei;
            value = val;
            name = n;
        } else {
            weight = 1;
            value = 0;
            name = n;
        }
    }

    /**
     * Auto-generated getter.
     *
     * @return item's weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Auto-generated getter.
     *
     * @return item's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Converts the item to a string containing the name, weight and value.
     *
     * @return Stringified item.
     */
    @Override
    public String toString() {
        return name + ": " + value + "/" + weight;
    }

    /**
     * The comparison function for items. Compares item i to the current item.
     *
     * @param i the item to compare to.
     * @return -1 if i is not more valuable, +1 is i is more valuable, 0 if
     * there is no gain or loss.
     */
    @Override
    public int compareTo(Item i) {
        return (int) Math.signum(weight * i.value - value * i.weight);
    }
}