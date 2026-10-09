package cn.edu.nwafu.jp.p5.data;

public class Mobile extends Item{
    protected String provider;

    public Mobile(String title,Float listPrice,String provider) {
        super(title, listPrice);
        this.provider = provider;
    }
    
    @Override
    public String toString() {
        return super.toString() + ".provider:" + provider + ".";
    }
}
