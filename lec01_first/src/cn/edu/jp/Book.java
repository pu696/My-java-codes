package cn.edu.jp;

public class Book {
	private String title; 
	private float listPrice;
	public Book() {
		super();
	}
	public Book(String title, float listPrice) {
		super();
		this.title = title;
		this.listPrice = listPrice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getListPrice() {
		return listPrice;
	}
	public void setListPrice(float listPrice) {
		this.listPrice = listPrice;
	}
	@Override
	public String toString() {
		return "Title:" + this.getTitle() + ",listPrice:" + this.getListPrice();
	}
}
