package cn.edu.cc6;

import java.util.*;

public class Store {

	public static void main(String[] args) {
		Mobile mobile1 = new Mobile("nova5S",3500.0f,"华为");
		Mobile mobile2 = new Mobile("nova4S",2500.0f,"华为");
		Mobile mobile3 = new Mobile("nova2S",2300.0f,"华为");
		Book book1 = new Book("Java Program,Fourth Edition",123.9f,"9-6555-6868-5");
		Book book2 = new Book("Java Program,Third Edition",98.9f,"9-6554-656-5");
		ArrayList<Item> arraylist = new ArrayList<>();
		arraylist.add(mobile1);
		arraylist.add(mobile2);
		arraylist.add(mobile3);
		arraylist.add(book1);
		arraylist.add(book2);
		StringBuilder sb1 = new StringBuilder("Items list:\n");
		for(Item item: arraylist) {
			sb1.append(item.toString()).append("\n");
		}
		sb1.append("There are 5 items.");
		System.out.println(sb1.toString());
		StringBuilder sb2 = new StringBuilder("Items list:\n");
		Iterator<Item> iterator1 = arraylist.iterator();
		while(iterator1.hasNext()) {
			sb2.append(iterator1.next().toString()).append("\n");
		}
		sb2.append("There are 5 items.");
		System.out.println(sb2.toString());
		TreeSet<Item> treeset = new TreeSet<Item>(new ItemComparator());
		treeset.add(mobile1);
		treeset.add(mobile2);
		treeset.add(mobile3);
		treeset.add(book1);
		treeset.add(book2);
		StringBuilder sb3 = new StringBuilder("Items list:\n");
		for(Item item : treeset) {
			sb3.append(item.toString()).append("\n");
		}
		sb3.append("There are 5 items.");
		System.out.println(sb3.toString());
		StringBuilder sb4 = new StringBuilder("Items list:\n");
		Iterator<Item> iterator2 = treeset.iterator();
		while(iterator2.hasNext()) {
			sb4.append(iterator2.next().toString()).append("\n");
		}
		sb4.append("There are 5 items.");
		System.out.println(sb4.toString());
		HashMap<String,Item> hashmap = new HashMap<>();
		hashmap.put(book1.getTitle(), book1);
		hashmap.put(book2.getTitle(), book2);
		hashmap.put(mobile1.getTitle(), mobile1);
		hashmap.put(mobile2.getTitle(), mobile2);
		hashmap.put(mobile3.getTitle(), mobile3);
		TreeMap<String,Item> treemap = new TreeMap<>(hashmap);
	}

}
