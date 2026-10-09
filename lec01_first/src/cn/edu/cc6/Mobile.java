package cn.edu.cc6;

public class Mobile extends Item{
	protected String provider;

	public Mobile(String title, Float listprice, String provider) {
		super(title, listprice);
		this.provider = provider;
	}

	@Override
	public String toString() {
		return super.toString() + ".provider:" + provider + ".";
	}
	
}
