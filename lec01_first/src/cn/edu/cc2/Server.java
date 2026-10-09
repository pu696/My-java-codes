package cn.edu.cc2;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		String[] answer = {"峰顶岩石面海拔8844.43米","48个","青海省"};
		ServerSocket serverForClient = null;
		Socket socketOnServer = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			serverForClient = new ServerSocket(2010);
		}
		catch(IOException e1) {
			System.out.println(e1);
		}
		try {
			System.out.println("等待客户呼叫");
			socketOnServer = serverForClient.accept();
			System.out.println("客户的地址:"+socketOnServer.getInetAddress());
			System.out.println("客户的端口:"+socketOnServer.getPort());
			out = new DataOutputStream(socketOnServer.getOutputStream());
			in = new DataInputStream(socketOnServer.getInputStream());
			for(int i = 0;i<answer.length;i++) {
				String s = in.readUTF();
				System.out.println("服务器收到客户的提问:"+s);
				out.writeUTF(answer[i]);
				Thread.sleep(1000);
			}
		}
		catch(Exception e) {
			System.out.println("客户已断开"+e);
		}
	}

}
