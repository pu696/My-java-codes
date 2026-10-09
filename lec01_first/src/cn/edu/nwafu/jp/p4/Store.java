package cn.edu.nwafu.jp.p4;

import cn.edu.nwafu.jp.p4.data.*;
import java.util.*;
import java.util.ArrayList;

public class Store {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Mobile mobile1 = new Mobile("nova5S",3500.0f,"华为");
        Mobile mobile2 = new Mobile("nova4S",2500.0f,"华为");
        Mobile mobile3   = new Mobile("nova2S",2300.0f,"华为");
        Book book1 = new Book("Java Program,Fourth Edition",123.9f,"9-6555-6868-5");
        Book book2 = new Book("Java Program,Third Edition",98.9f,"9-6554-656-5");
        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(mobile1);
        arrayList.add(mobile2);
        arrayList.add(mobile3);
        arrayList.add(book1);
        arrayList.add(book2);
        StringBuilder sb1 = new StringBuilder("Items list:\n");
        for (Item item : arrayList) {
            sb1.append(item.toString()).append("\n");
        }
        sb1.append("There are 5 items.");
        System.out.println(sb1.toString());
        StringBuilder sb2 = new StringBuilder("Items list:\n");
        Iterator<Item> iterator1 = arrayList.iterator();
        while (iterator1.hasNext()) {
            sb2.append(iterator1.next().toString()).append("\n");
        }
        sb2.append("There are 5 items.");
        System.out.println(sb2.toString());
    }

}
