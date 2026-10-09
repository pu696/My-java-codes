package cn.edu.test;
import java.util.Scanner;
public class TestScore {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int score = sc.nextInt();
try {
System.out.println("您的成绩范围：" + Grade.getGrade(score));
} catch (InputException e) {
//e.printStackTrace();
System.out.println(e.getMessage());
}catch(Exception e){
e.printStackTrace();
}
}
}