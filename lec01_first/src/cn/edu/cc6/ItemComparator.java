package cn.edu.cc6;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return Float.compare(item1.listprice, item2.listprice);
    }
}
