package cn.edu.cc2;

import java.io.*;
import java.net.*;

public class Client {

	public static void main(String[] args) {
		String [] mess = {"珠穆朗玛峰的高度是多少？","亚洲有多少个国家？","西宁是哪个省的省会"};
		Socket mysocket;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			mysocket = new Socket("127.0.0.1",2010);
			in = new DataInputStream(mysocket.getInputStream());
			out = new DataOutputStream(mysocket.getOutputStream());
			for(int i = 0;i<mess.length;i++) {
				out.writeUTF(mess[i]);
				String s = in.readUTF();
				System.out.println("客户收到服务器的回答："+s);
				Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("服务器已断开"+e);
		}
	}

}
