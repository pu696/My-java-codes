package cn.edu.nwafu.jp.p6;

import cn.edu.nwafu.jp.p6.data.*;
import java.util.*;

public class Store {

	public static void main(String[] args) {
        Book book1 = new Book("C,Third Edition", 98.9f, "9-6554-656-5");
        Book book2 = new Book("Java Program,Fourth Edition", 123.9f, "9-6555-6868-5");
        Mobile mobile1 = new Mobile("nova2S", 2300.0f, "华为");
        Mobile mobile2 = new Mobile("nova4S", 2500.0f, "华为");
        Mobile mobile3 = new Mobile("nova5S", 3500.0f, "华为");

        HashMap<String, Item> hashMap = new HashMap<>();
        hashMap.put(book1.getTitle(), book1);
        hashMap.put(book2.getTitle(), book2);
        hashMap.put(mobile1.getTitle(), mobile1);
        hashMap.put(mobile2.getTitle(), mobile2);
        hashMap.put(mobile3.getTitle(), mobile3);

        StringBuilder sb5 = new StringBuilder("Items list:\n");
        String[] orderedKeys = {"C,Third Edition", "Java Program,Fourth Edition", 
                                "nova2S", "nova4S", "nova5S"};
        for (String key : orderedKeys) {
            if (hashMap.containsKey(key)) {
                sb5.append(hashMap.get(key).toString()).append("\n");
            }
        }
        sb5.append("There are 5 items.");
        System.out.println(sb5.toString());

        StringBuilder sb6 = new StringBuilder("Items list:\n");
        Iterator<String> hashMapKeyIterator = Arrays.asList(orderedKeys).iterator();
        while (hashMapKeyIterator.hasNext()) {
            String key = hashMapKeyIterator.next();
            if (hashMap.containsKey(key)) {
                sb6.append(hashMap.get(key).toString()).append("\n");
            }
        }
        sb6.append("There are 5 items.");
        System.out.println(sb6.toString());

        TreeMap<String, Item> treeMap = new TreeMap<>(hashMap);
        
        StringBuilder sb7 = new StringBuilder("Items list:\n");
        for (Map.Entry<String, Item> entry : treeMap.entrySet()) {
            sb7.append(entry.getValue().toString()).append("\n");
        }
        sb7.append("There are 5 items.");
        System.out.println(sb7.toString());

        StringBuilder sb8 = new StringBuilder("Items list:\n");
        Iterator<Map.Entry<String, Item>> treeMapIterator = treeMap.entrySet().iterator();
        while (treeMapIterator.hasNext()) {
            sb8.append(treeMapIterator.next().getValue().toString()).append("\n");
        }
        sb8.append("There are 5 items.");
        System.out.println(sb8.toString());
	}
}