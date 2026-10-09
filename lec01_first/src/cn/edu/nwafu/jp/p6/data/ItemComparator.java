package cn.edu.nwafu.jp.p6.data;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        return Float.compare(item1.listPrice, item2.listPrice);
    }
}