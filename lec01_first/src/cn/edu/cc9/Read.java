package cn.edu.cc9;

import java.io.*;

public class Read implements Runnable{
	DataInputStream in;
	public void setDataInputStream(DataInputStream in) {
		this.in = in;
	}
	@Override
	public void run() {
		double result = 0;
		while(true) {
			try {
				result = in.readDouble();
				System.out.println("圆的面积："+result);
				System.out.println("输入圆的半径(放弃请输入N)：");
			}
			catch(IOException e) {
				System.out.println("与服务器已断开"+e);
				break;
			}
		}
		
	}

}
