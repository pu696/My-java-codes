package cn.edu.nwsuaf.jp.p3.data;

public abstract class Product implements IProduct{
	   protected String title = "(no title)";
	   protected float listPrice;
	   protected static int count;
	   protected float sales;
	   public Product() {
		   super();
	   }
	   public Product(String title, float listPrice) {
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
	   public static int getCount() {
		   return count;
	   }
	   public static void setCount(int count) {
		   Product.count = count;
	   }
	   public float getSales() {
		   return sales;
	   }
	   public void setSales(float sales) {
		   this.sales = sales;
	   }
}
