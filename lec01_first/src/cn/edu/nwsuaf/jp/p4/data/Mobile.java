package cn.edu.nwsuaf.jp.p4.data;

public class Mobile extends Product{
		public Mobile() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Mobile(String title, Float listPrice) {
			super(title,listPrice);
		}
		public void sell(int number) {
			 this.sales = number * this.listPrice;
		}
	}
