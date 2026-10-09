package cn.edu.cc4;

import java.util.Scanner;

public class test1 {
	public static void main(String []args) throws InputException {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		try {
			System.out.println("您的成绩范围："+Grade.getGrade(score));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
