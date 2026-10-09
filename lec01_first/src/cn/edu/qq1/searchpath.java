package cn.edu.qq1;

import java.util.Scanner;
import java.io.File;
public class searchpath {
	public static void main(String[] args)  {
	        Scanner sc = new Scanner(System.in); 
	            String line = sc.nextLine();
	            File file = new File(line);
	            fileDir(file);
	}
	public static void fileDir(File dir) {
		File[] files = dir.listFiles();
		for(File file : files) {
			if(file.isDirectory()) {
				fileDir(file);
			}
			System.out.println(file.getAbsolutePath());
		}
	}        
}
    



