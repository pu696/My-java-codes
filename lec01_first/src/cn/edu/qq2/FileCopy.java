package cn.edu.qq2;

import java.io.*;
import java.util.Scanner;

public class FileCopy {
    
    // 方法1: 使用字节流
    public static void copyWithByteStream(File source, File destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("字节流复制完成! 从 " + source.getName() + " 到 " + destination.getName());
            
        } catch (IOException e) {
            System.out.println("字节流复制失败: " + e.getMessage());
        }
    }
    
    // 方法2: 使用字符流
    public static void copyWithCharStream(File source, File destination) {
        try (FileReader fr = new FileReader(source);
             FileWriter fw = new FileWriter(destination)) {
            
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, charsRead);
            }
            System.out.println("字符流复制完成! 从 " + source.getName() + " 到 " + destination.getName());
            
        } catch (IOException e) {
            System.out.println("字符流复制失败: " + e.getMessage());
        }
    }
    
    // 方法3: 使用带缓冲的字符流
    public static void copyWithBufferedCharStream(File source, File destination) {
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("缓冲字符流复制完成! 从 " + source.getName() + " 到 " + destination.getName());
            
        } catch (IOException e) {
            System.out.println("缓冲字符流复制失败: " + e.getMessage());
        }
    }
    
    // 方法4: 使用Scanner和PrintStream
    public static void copyWithScannerPrintStream(File source, File destination) {
        try (Scanner scanner = new Scanner(source);
             PrintStream ps = new PrintStream(new FileOutputStream(destination))) {
            
            while (scanner.hasNextLine()) {
                ps.println(scanner.nextLine());
            }
            System.out.println("Scanner和PrintStream复制完成! 从 " + source.getName() + " 到 " + destination.getName());
            
        } catch (IOException e) {
            System.out.println("Scanner和PrintStream复制失败: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // 假设当前路径下已经有a.txt，创建b.txt用于复制
        File sourceFile = new File("d:\\a.txt");
        File destFile1 = new File("d:\\b_byte.txt");
        File destFile2 = new File("d:\\b_char.txt");
        File destFile3 = new File("d:\\b_buffered.txt");
        File destFile4 = new File("d:\\b_scanner.txt");
        
        // 检查源文件是否存在
        if (!sourceFile.exists()) {
            System.out.println("源文件 a.txt 不存在，正在创建测试文件...");
            // 创建测试源文件
            try (PrintWriter pw = new PrintWriter(sourceFile)) {
                pw.println("这是测试文件的第一行");
                pw.println("这是测试文件的第二行");
                pw.println("Java输入输出流实验");
                pw.println("使用四种方法实现文件复制");
                pw.println("文件复制完成!");
            } catch (FileNotFoundException e) {
                System.out.println("创建测试文件失败: " + e.getMessage());
                return;
            }
            System.out.println("已创建测试文件 a.txt");
        }
        
        System.out.println("开始使用四种方法复制文件...\n");
        
        // 使用四种方法复制文件
        copyWithByteStream(sourceFile, destFile1);
        copyWithCharStream(sourceFile, destFile2);
        copyWithBufferedCharStream(sourceFile, destFile3);
        copyWithScannerPrintStream(sourceFile, destFile4);
        
        System.out.println("\n所有复制操作完成!");
        System.out.println("生成的文件:");
        System.out.println("- " + destFile1.getName());
        System.out.println("- " + destFile2.getName());
        System.out.println("- " + destFile3.getName());
        System.out.println("- " + destFile4.getName());
        
        // 验证文件内容
        System.out.println("\n验证复制结果:");
        verifyFileContent(sourceFile, destFile1, "字节流");
        verifyFileContent(sourceFile, destFile2, "字符流");
        verifyFileContent(sourceFile, destFile3, "缓冲字符流");
        verifyFileContent(sourceFile, destFile4, "Scanner和PrintStream");
    }
    
    // 验证文件内容是否一致
    private static void verifyFileContent(File original, File copy, String methodName) {
        try (BufferedReader br1 = new BufferedReader(new FileReader(original));
             BufferedReader br2 = new BufferedReader(new FileReader(copy))) {
            
            String line1, line2;
            int lineNum = 1;
            boolean identical = true;
            
            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    System.out.println(methodName + " 复制: 第 " + lineNum + " 行内容不一致");
                    identical = false;
                    break;
                }
                lineNum++;
            }
            
            if (identical) {
                System.out.println(methodName + " 复制: 文件内容完全一致 ✓");
            }
            
        } catch (IOException e) {
            System.out.println(methodName + " 验证失败: " + e.getMessage());
        }
    }
}

	

