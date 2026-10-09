package cn.edu.cc1;

import java.io.*;

public class test2 {

	public static void main(String[] args) throws FileNotFoundException {
		File f2 = new File("d:\\d_byte.txt");
		byte[] a = "新年快乐".getBytes();
 	    byte[] b = "Happy New Year".getBytes();
 	    try {
 	       FileOutputStream fos = new FileOutputStream(f2,true);
 	       System.out.println(f2.getName()+"的大小:"+f2.length()+"字节");
 	       
 	       fos.write(a);
 	       fos.close();
 	       fos = new FileOutputStream(f2,true);
 	       System.out.println(f2.getName()+"的大小:"+f2.length()+"字节");
 	       
 	       fos.write(b, 0, b.length);
 	       System.out.println(f2.getName()+"的大小:"+f2.length()+"字节");
 	       
 	       fos.close();
 	    }
 	    catch(IOException e) {
 	    	System.out.println("Error"+e);
 	    }

	}

}
