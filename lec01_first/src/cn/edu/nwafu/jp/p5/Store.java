package cn.edu.nwafu.jp.p5;

import cn.edu.nwafu.jp.p5.data.*;
import java.util.*;

public class Store {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Mobile mobile1 = new Mobile("nova5S",3500.0f,"华为");
        Mobile mobile2 = new Mobile("nova4S",2500.0f,"华为");
        Mobile mobile3 = new Mobile("nova2S",2300.0f,"华为");
        Book book1 = new Book("Java Program,Fourth Edition",123.9f,"9-6555-6868-5");
        Book book2 = new Book("Java Program,Third Edition",98.9f,"9-6554-656-5");
        TreeSet<Item> treeSet = new TreeSet<>(new ItemComparator());
        treeSet.add(book1);
        treeSet.add(book2);
        treeSet.add(mobile1);
        treeSet.add(mobile2);
        treeSet.add(mobile3);
        StringBuilder sb3 = new StringBuilder("Items list:\n");
        for (Item item : treeSet) {
            sb3.append(item.toString()).append("\n");
        }
        sb3.append("There are 5 items.");
        System.out.println(sb3.toString());

        StringBuilder sb4 = new StringBuilder("Items list:\n");
        Iterator<Item> iterator2 = treeSet.iterator();
        while (iterator2.hasNext()) {
            sb4.append(iterator2.next().toString()).append("\n");
        }
        sb4.append("There are 5 items.");
        System.out.println(sb4.toString());
    }

}

