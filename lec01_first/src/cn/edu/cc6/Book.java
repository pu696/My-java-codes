package cn.edu.cc6;

public class Book extends Item{
	private String isbn;

	public Book(String title, Float listprice, String isbn) {
		super(title, listprice);
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return super.toString() + ".isbn:" + isbn + ".";
	}
	
	
}
