package cn.edu.cc9;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		ServerThread thread;
		Socket you = null;
		while(true) {
			try {
				server = new ServerSocket(2010);
			}
			catch(IOException e1) {
				System.out.println("正在监听");
			}
			try {
				System.out.println("等待用户呼叫");
				you = server.accept();
				System.out.println("客户的地址："+you.getInetAddress());
			}
			catch(IOException e) {
				System.out.println("正在等待客户");
			}
			if(you!=null) {
				new ServerThread(you).start();
			}
		}
	}

}

class ServerThread extends Thread{
	Socket socket;
	DataOutputStream out= null;
	DataInputStream in= null;
	String s = null;
	ServerThread(Socket t){
		socket = t;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		}
		catch(IOException e) {}
	}
	public void run() {
		while(true) {
			try {
				double r = in.readDouble();
				double area = Math.PI*r*r;
				out.writeDouble(area);
			}
			catch(IOException e) {
				System.out.println("客户离开");
				return;
			}
		}
	}
}
