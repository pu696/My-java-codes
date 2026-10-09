package cn.edu.nwafu.jp.p4.data;

public abstract class Item extends Object implements Comparable<Item>{
    
    protected Float listPrice;
    protected static int count;
    protected String title;
    
    public Item(String title,Float listPrice) {
        super();
        this.title = title;
        this.listPrice = listPrice;
        count++;
    }

    @Override
    public int compareTo(Item o) {
        return this.listPrice.compareTo(o.listPrice);
    }

    @Override
    public String toString() {
        return String.format("title:%s,listPrice:%.1fRMB", title, listPrice);
    }
}
