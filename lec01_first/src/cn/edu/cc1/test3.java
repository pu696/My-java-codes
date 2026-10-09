package cn.edu.cc1;

import java.io.*;

public class test3 {
	public static void main(String args[]) {
	File f1 = new File("d:\\c.txt");
	File f2 = new File("d:\\d_byte.txt");
	char c[] = new char[19];
	try {
		Writer out = new FileWriter(f2,true);
		Reader in = new FileReader(f1);
		int n = -1;
		while((n=in.read(c))!=-1) {
			out.write(c, 0, n);
		}
		out.flush();
		out.close();
	}
	catch(IOException e) {
		System.out.println("Error"+e);
	}
}
}
