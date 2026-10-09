package cn.edu.p3;
import java.util.Scanner;
public class EcmDef {
	public static double ecm(int a,int b)throws EcDef{
		if(a<0||b<0) {
			throw new EcDef("输入参数不能为负数");
		}
		return (double)a/b;
	}
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String input1 = sc1.nextLine();
		String input2 = sc2.nextLine();
		try {
			if(input1=="" || input2=="") {
				throw new ArrayIndexOutOfBoundsException("缺少命令行参数");
			}
			int num1 = Integer.parseInt(input1);
			int num2 = Integer.parseInt(input2);
			if(num2==0) {
				throw new ArithmeticException("除数不能为0");
			}
			
			double result = ecm(num1,num2);
			System.out.println("计算结果："+result);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("异常:"+ e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("异常:数据类型不一致" + e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println("异常:" + e.getMessage());
		}catch(EcDef e) {
			System.out.println("异常:" + e.getMessage());
		}catch(Exception e) {
			System.out.println("其他异常:" + e.getMessage());
		}
	}
}
