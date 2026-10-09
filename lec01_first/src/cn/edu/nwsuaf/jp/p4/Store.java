package cn.edu.nwsuaf.jp.p4;

import java.util.*;
import cn.edu.nwsuaf.jp.p4.data.*;
import java.io.*;

public class Store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scanner = new Scanner(System.in);
	    
		System.out.println("请输入货币单位：");
		String currencyInput = scanner.nextLine().trim().toUpperCase();
        Mobile mobile1 = new Mobile("Mate15 Pro", 6800.9f);
        Mobile mobile2 = new Mobile("Novas 9s", 3800.9f);
        Mp3Player mp3Player1 = new Mp3Player("Play", 820.0f);
        Mp3Player mp3Player2 = new Mp3Player("Beyond these shores", 50.0f);
        Product[] products = {mobile1, mobile2, mp3Player1, mp3Player2};
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\product.txt"))) {
            oos.writeObject(products);
            System.out.println("产品对象已序列化到 product.txt");
        } catch (IOException e) {
            System.out.println("序列化失败: " + e.getMessage());
        }
        Product[] loadedProducts = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\product.txt"))) {
            loadedProducts = (Product[]) ois.readObject();
            System.out.println("从 product.txt 反序列化产品对象成功");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("反序列化失败: " + e.getMessage());
            loadedProducts = products;
        }
        Arrays.sort(loadedProducts);
        StringBuilder text = new StringBuilder("Sales:\n\n");
        for (Product product : products) {
            text.append(product.getTitle())
                .append(", ")
                .append(product.getListPrice())
                .append("RMB\n");
        }
        text.append("\nThere are ").append(products.length).append(" products.");
        System.out.println(text.toString());
        String mob1 = loadedProducts[0].getTitle();
        String mob2 = loadedProducts[1].getTitle();
        String mp3_1 = loadedProducts[2].getTitle();
        String mp3_2 = loadedProducts[3].getTitle();
        int x = loadedProducts[0].compareTo(loadedProducts[1]);
        int y = loadedProducts[2].compareTo(loadedProducts[3]);    
        loadedProducts[0].sell(60);  
        loadedProducts[1].sell(1);   
        loadedProducts[2].sell(100); 
        loadedProducts[3].sell(1);   
        cn.edu.nwsuaf.jp.p4.data.Currency currency;
        if (currencyInput.equals("EURO")) {
            currency = cn.edu.nwsuaf.jp.p4.data.Currency.EURO;
            float mo1=currency.convertToRMB(6800.9f);
            float mo2=currency.convertToRMB(3800.9f);
            float mp1=currency.convertToRMB(820.0f);
            float mp2=currency.convertToRMB(50.0f);
            System.out.println("Sales:\n");
            System.out.println("Title:" + mp3_2 + ",price:" + mp2 + " ￥(" + loadedProducts[3].getListPrice() + "€),sales:" + 1 * mp2 + " ￥(" + loadedProducts[3].getSales() + "€).");
            System.out.println("Title:" + mp3_1 + ",price:" + mp1 + " ￥(" + loadedProducts[2].getListPrice() + "€),sales:" + 100 * mp1 + " ￥(" + loadedProducts[2].getSales() + "€).");
            System.out.println("Title:" + mob2 + ",price:" + mo2 + " ￥(" + loadedProducts[1].getListPrice() + "€),sales:" + 1 * mo2 + " ￥(" + loadedProducts[1].getSales() + "€).");
            System.out.println("Title:" + mob1 + ",price:" + mo1 + " ￥(" + loadedProducts[0].getListPrice() + "€),sales:" + 60 * mo2 + " ￥(" + loadedProducts[0].getSales() + "€).");
            System.out.println("\n\nThere are 4 items.");
        } else {
            currency = cn.edu.nwsuaf.jp.p4.data.Currency.RMB;
            float a = 6.99f;
            currency.setExchangeRate(a);
            float mo1 = currency.convertToEURO(6800.9f);
            float mo2 = currency.convertToEURO(3800.9f);
            float mp1 = currency.convertToEURO(820.0f);
            float mp2 = currency.convertToEURO(50.0f);
            System.out.println("Sales:\n");
            System.out.println("Title:" + mp3_2 + ",price:" + loadedProducts[3].getListPrice() + " ￥(" + mp2 + "€),sales:" + loadedProducts[3].getSales() + " ￥(" + 1 * mp2 + "€).");
            System.out.println("Title:" + mp3_1 + ",price:" + loadedProducts[2].getListPrice() + " ￥(" + mp1 + "€),sales:" + loadedProducts[2].getSales() + " ￥(" + 100 * mp1 + "€).");
            System.out.println("Title:" + mob2 + ",price:" + loadedProducts[1].getListPrice() + " ￥(" + mo2 + "€),sales:" + loadedProducts[1].getSales() + " ￥(" + 1 * mo2 + "€).");
            System.out.println("Title:" + mob1 + ",price:" + loadedProducts[0].getListPrice() + " ￥(" + mo1 + "€),sales:" + loadedProducts[0].getSales() + " ￥(" + 60 * mo1 + "€).");
            System.out.println("\n\nThere are 4 items.");
        }
        scanner.close();
        }
}

