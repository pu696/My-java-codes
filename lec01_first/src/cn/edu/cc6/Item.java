package cn.edu.cc6;

public abstract class Item extends Object implements Comparable<Item>{
	protected Float listprice;
	protected static int count;
	protected String title;
	
	public Item(String title, Float listprice) {
		super();
		this.title = title;
		this.listprice = listprice;
		count++;
	}
	@Override
	public int compareTo(Item o) {
		return this.listprice.compareTo(o.listprice);
	}
	@Override
	public String toString() {
		return String.format("title:%s,listPrice:%.1fRMB", title, listprice);
	}
	public Float getListprice() {
		return listprice;
	}
	public void setListprice(Float listprice) {
		this.listprice = listprice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
