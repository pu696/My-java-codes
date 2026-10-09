package cn.edu.cc1;

import java.io.*;

public class test1 {
       public static void main(String []args) throws IOException {
    	   File f1 = new File("d:\\c.txt");
    	   try {
    		   boolean result =f1.createNewFile();
    	   }catch(IOException e){
    		   e.printStackTrace();
    	   }
    	   File f2 = new File("d:\\d_byte.txt");
    	   try {
    		   boolean result =f2.createNewFile();
    	   }catch(IOException e){
    		   e.printStackTrace();
    	   }
    	   FileOutputStream fos = new FileOutputStream(f2,true);
    	   FileInputStream fis = new FileInputStream(f1);
    	   
    	   byte[] bt = new byte[100];
    	   byte[] a = "新年快乐".getBytes();
    	   byte[] b = "Happy New Year".getBytes();

    	   int n=-1;
    	   try {
    	   while((n = fis.read(bt))!=-1) {
    		   fos.write(bt, 0, n);
    		   String s = new String(bt,0,n);
    		   System.out.print(s);
    	   }
    	   fis.close();
    	   }
    	   catch(IOException e) {
    		   System.out.println(e);
    	   }
       }
}
