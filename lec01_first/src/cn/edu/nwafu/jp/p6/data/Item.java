package cn.edu.nwafu.jp.p6.data;

public abstract class Item extends Object implements Comparable<Item>{
    
    protected Float listPrice;
    protected static int count;
    private String title;
    
    public Item(String title,Float listPrice) {
        super();
        this.setTitle(title);
        this.listPrice = listPrice;
        count++;
    }

    @Override
    public int compareTo(Item o) {
        return this.listPrice.compareTo(o.listPrice);
    }
    
    @Override
    public String toString() {
        return String.format("title:%s,listPrice:%.1fRMB", getTitle(), listPrice);
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
