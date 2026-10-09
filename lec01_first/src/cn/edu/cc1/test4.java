package cn.edu.cc1;

import java.io.*;
import java.util.*;

public class test4 {
	public static void main(String args[]) {
		File f1 = new File("d:\\c.txt");
		File f2 = new File("d:\\d_byte.txt");
		try {
			Writer out = new FileWriter(f2);
			BufferedWriter bufferWrite = new BufferedWriter(out);
			Reader in = new FileReader(f1);
			BufferedReader bufferRead = new BufferedReader(in);
			String str = null;
			while((str=bufferRead.readLine())!=null) {
				StringTokenizer fenxi = new StringTokenizer(str);
				int count = fenxi.countTokens();
				str = str +"句子中单词个数："+count;
				bufferWrite.write(str);
				bufferWrite.newLine();
			}
			bufferWrite.close();
			out.close();
			in = new FileReader(f2);
			bufferRead = new BufferedReader(in);
			String s = null;
			System.out.println(f2.getName()+"内容：");
			while((s=bufferRead.readLine())!=null) {
				System.out.println(s);
			}
			bufferRead.close();
			in.close();
		}
		catch(IOException e) {
			System.out.println(e.toString());
		}
	}
}
