package cn.edu.nwsuaf.jp.p4.data;

import java.io.Serializable;
import java.util.Objects;

public abstract class Product extends Object implements Serializable, Comparable<Product> {
    private static final long serialVersionUID = 1L;
    
    protected String title = "(no title)";
    protected Float listPrice;
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
    
    @Override
    public int hashCode() {
        return Objects.hash(listPrice, sales, title);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        return Float.floatToIntBits(listPrice) == Float.floatToIntBits(other.listPrice)
                && Float.floatToIntBits(sales) == Float.floatToIntBits(other.sales)
                && Objects.equals(title, other.title);
    }
    
    @Override
    public String toString() {
        return "Title:" + title + ",price:" + listPrice + ",sales:" + sales + "￥";
    }
    
    @Override
    public int compareTo(Product product) {
        return product.listPrice.compareTo(this.listPrice);
    }
    public void sell(int number) {
		 this.sales = number * this.listPrice;
	}
}
