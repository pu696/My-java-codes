package cn.edu.pp;
import java.io.*;
import java.math.BigInteger;
 
public class Main {
 
	public static void main(String[] args) throws FileNotFoundException {
		int n=123456;
		BigInteger a=new BigInteger("2");
		BigInteger b=new BigInteger("3");
		BigInteger a1=new BigInteger("2");
		BigInteger b1=new BigInteger("3");
		for(int i=1;i<n;i++) {
			BigInteger ta=a;
			a=a.multiply(a1).subtract(b.multiply(b1));//a=a*a1-b*b1;
			b=ta.multiply(b1).add(b.multiply(a1));//b=a*b1+b*a1
		}
		System.out.println(a+(b.compareTo(BigInteger.ZERO)>0?"+":"")+b+"i");
		System.out.println("end");
	}
}