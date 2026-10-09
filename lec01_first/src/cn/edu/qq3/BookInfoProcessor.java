package cn.edu.qq3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Book {
    private String id;
    private String name;
    private String edition;
    private double price;
    private int sales;
    
    public Book(String id, String name, String edition, double price, int sales) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.price = price;
        this.sales = sales;
    }
    
    // getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEdition() { return edition; }
    public double getPrice() { return price; }
    public int getSales() { return sales; }
    
    public void setPrice(double price) { this.price = price; }
    
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%.1f\t%d", id, name, edition, price, sales);
    }
}

public class BookInfoProcessor {
    
    // 读取书籍信息
    public static List<Book> readBooks(String filename) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 跳过标题行
                }
                
                String[] parts = line.split("\t");
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String edition = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    int sales = Integer.parseInt(parts[4].trim());
                    
                    books.add(new Book(id, name, edition, price, sales));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return books;
    }
    
    // 写入书籍信息
    public static void writeBooks(List<Book> books, String filename) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            // 写入标题
            pw.println("编号\t名称\t版本\t价格\t销售额");
            
            // 写入书籍信息
            for (Book book : books) {
                pw.println(book.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // 创建原始书籍信息文件
        String inputFile = "d:\\pbookinfo.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(inputFile))) {
            pw.println("编号\t名称\t版本\t价格\t销售额");
            pw.println("1001\tJava程序设计\t第2版\t56.9\t560");
            pw.println("1002\tJava开发实战\t第1版\t98.9\t820");
            pw.println("1003\tC++程序设计指南\t第3版\t62.5\t362");
            pw.println("1004\tEJB3.0入门经典\t第1版\t59.8\t1280");
            pw.println("1005\tSpring3.0 in Action\t第3版\t95.8\t1189");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 读取书籍信息
        List<Book> books = readBooks(inputFile);
        
        // 修改第3本和第4本书的价格
        if (books.size() >= 4) {
            books.get(2).setPrice(books.get(2).getPrice() + 20); // 第3本书
            books.get(3).setPrice(books.get(3).getPrice() + 30); // 第4本书
        }
        
        // 写入新的书籍信息文件
        String outputFile = "d:\\pbookinfonew.txt";
        writeBooks(books, outputFile);
        
        System.out.println("书籍信息处理完成！新的文件已保存为: " + outputFile);
        
        // 显示修改后的结果
        System.out.println("\n修改后的书籍信息:");
        System.out.println("编号\t名称\t版本\t价格\t销售额");
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}
