package cn.edu.nwsuaf.jp.p4.data;

public class Mp3Player extends Product {
		 public Mp3Player() {
			super();
			// TODO Auto-generated constructor stub
		 }
		 public Mp3Player(String title, Float listPrice) {
			super(title, listPrice);
		 }
		 public void sell(int number) {
			 this.sales = number * this.listPrice;
		 }
		 
	}

