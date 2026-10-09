package cn.edu.tt;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("输入服务器的IP地址: ");
            String ip = scanner.nextLine();
            System.out.print("输入端口号: ");
            int port = scanner.nextInt();
            scanner.nextLine(); // 清除缓冲区
            
            // 连接服务器
            socket = new Socket(ip, port);
            System.out.println("已连接到服务器: " + socket.getInetAddress());
            
            // 获取输入输出流
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            
            // 启动读取线程
            ReadThread readThread = new ReadThread(in);
            new Thread(readThread).start();
            
            System.out.println("输入数字 (0-10)，输入 'N' 退出:");
            
            while (true) {
                System.out.print("请输入数字: ");
                String input = scanner.nextLine().trim();
                
                if ("N".equalsIgnoreCase(input)) {
                    System.out.println("退出程序");
                    break;
                }
                
                try {
                    int number = Integer.parseInt(input);
                    if (number >= 0 && number <= 10) {
                        out.writeUTF(String.valueOf(number));
                        out.flush();
                        System.out.println("已发送: " + number);
                    } else {
                        System.out.println("请输入0-10之间的数字");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("请输入有效的数字");
                } catch (IOException e) {
                    System.out.println("发送失败，连接可能已断开");
                    break;
                }
            }
            
        } catch (UnknownHostException e) {
            System.out.println("无法找到服务器: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("连接失败: " + e.getMessage());
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// 读取线程
class ReadThread implements Runnable {
    private DataInputStream in;
    
    public void setDataInputStream(DataInputStream in) {
        this.in = in;
    }
    
    public ReadThread(DataInputStream in) {
        this.in = in;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                String result = in.readUTF();
                System.out.println("服务器返回: " + result);
            }
        } catch (EOFException e) {
            System.out.println("服务器关闭了连接");
        } catch (SocketException e) {
            System.out.println("连接已断开");
        } catch (IOException e) {
            System.out.println("读取数据错误: " + e.getMessage());
        }
    }
}
