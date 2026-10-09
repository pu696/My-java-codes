package cn.edu.qq4;
import java.io.*;
import java.util.*;

public class WordCount {
    
    public static void countWords(String filename) {
        TreeMap<String, Integer> wordCount = new TreeMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                // 使用正则表达式分割单词（考虑标点符号）
                String[] words = line.split("[\\s\\p{Punct}]+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        String cleanWord = word.toLowerCase();
                        wordCount.put(cleanWord, wordCount.getOrDefault(cleanWord, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 输出统计结果
        System.out.println("单词统计结果（按字母顺序排序）:");
        System.out.println("单词\t\t出现次数");
        System.out.println("------------------------");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.printf("%-15s\t%d%n", entry.getKey(), entry.getValue());
        }
    }
    
    public static void main(String[] args) {
        // 创建测试文件
        String testFile = "english_text.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(testFile))) {
            pw.println("Hello world! This is a test file for word counting.");
            pw.println("Java programming is fun and interesting.");
            pw.println("We are learning about input and output streams in Java.");
            pw.println("Word count program should work correctly.");
            pw.println("Hello again, this is the last line.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // 执行单词统计
        countWords(testFile);
    }
}





