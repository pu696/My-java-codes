package cn.edu.nwsuaf.jp.p3.data;

public class Mobile extends Product{
	public String provider;
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(String title, float listPrice,String provider) {
		super(title,listPrice);
		this.provider = provider;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sell(int number) {
		// TODO Auto-generated method stub
		this.sales = this.listPrice*number;
	}
	@Override
	public String toString() {
		return title +","+ listPrice +",RMB,provider:" + provider;
	}
	
}
