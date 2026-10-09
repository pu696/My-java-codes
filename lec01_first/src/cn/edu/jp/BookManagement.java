package cn.edu.jp;

public class BookManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		String s1 = book.getTitle();
		float s2 = book.getListPrice();
		String s3 = book.toString();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
