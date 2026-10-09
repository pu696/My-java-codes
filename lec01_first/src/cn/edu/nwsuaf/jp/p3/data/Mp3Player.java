package cn.edu.nwsuaf.jp.p3.data;

public class Mp3Player extends Product {
     public String artist;
     
	 public Mp3Player() {
		super();
		// TODO Auto-generated constructor stub
	 }
	 public Mp3Player(String title, float listPrice,String artist) {
		super(title, listPrice);
		this.artist = artist;
	 }
	 public String getArtist() {
		 return artist;
	 }
	 public void setArtist(String artist) {
		 this.artist = artist;
	 }
	 @Override
	 public String toString() {
		return super.toString() + "artist:" + this.getArtist();
	 }
	 @Override
	public void sell() {
		// TODO Auto-generated method stub
	}
	 @Override
	 public void sell(int numberOfITems) {
		this.sales = this.listPrice*numberOfITems;
	 }
}
