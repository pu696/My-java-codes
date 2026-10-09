package cn.edu.nwafu.jp.p6.data;

public class Book extends Item{
    private String isbn;

    public Book(String title,Float listPrice,String isbn) {
        super(title, listPrice);
        this.isbn = isbn;
    }
    
    @Override
    public String toString() {
        return super.toString() + ".isbn:" + isbn + ".";
    }
}
