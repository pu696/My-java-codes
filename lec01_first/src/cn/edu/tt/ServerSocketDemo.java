package cn.edu.tt;

import java.io.*;
import java.net.*;

public class ServerSocketDemo {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        
        try {
            // 创建服务器Socket，监听端口2010
            server = new ServerSocket(2010);
            System.out.println("服务器启动，正在监听端口2010...");
            
            while (true) {
                try {
                    // 等待客户端连接
                    System.out.println("等待客户端连接...");
                    socket = server.accept();
                    System.out.println("客户端已连接，地址: " + socket.getInetAddress());
                    
                    // 为每个客户端创建一个新线程
                    new ServerThread(socket).start();
                } catch (IOException e) {
                    System.out.println("客户端连接异常: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败: " + e.getMessage());
        } finally {
            try {
                if (server != null && !server.isClosed()) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// 处理客户端请求的线程类
class ServerThread extends Thread {
    private Socket socket;
    private DataOutputStream out = null;
    private DataInputStream in = null;
    private String[] zh = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾"};
    
    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            // 获取输入输出流
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("创建流失败: " + e.getMessage());
        }
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                try {
                    // 读取客户端发送的数据
                    String receivedData = in.readUTF();
                    System.out.println("接收到客户端数据: " + receivedData);
                    
                    try {
                        // 将字符串转换为整数
                        int n = Integer.parseInt(receivedData.trim());
                        
                        // 检查数字是否在0-10范围内
                        if (n >= 0 && n < zh.length) {
                            out.writeUTF(zh[n]);
                            System.out.println("返回给客户端: " + zh[n]);
                        } else {
                            out.writeUTF("数据越界！请输入0-10之间的数字。");
                            System.out.println("数据越界: " + n);
                        }
                    } catch (NumberFormatException e) {
                        out.writeUTF("错误：请输入有效的数字！");
                        System.out.println("接收到无效的数字格式: " + receivedData);
                    }
                    
                    out.flush(); // 确保数据发送
                    
                } catch (EOFException e) {
                    System.out.println("客户端断开连接");
                    break;
                } catch (IOException e) {
                    System.out.println("通信错误: " + e.getMessage());
                    break;
                }
            }
        } finally {
            // 关闭资源
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null && !socket.isClosed()) socket.close();
                System.out.println("连接已关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
