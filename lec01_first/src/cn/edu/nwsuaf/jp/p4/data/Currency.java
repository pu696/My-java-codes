package cn.edu.nwsuaf.jp.p4.data;

public enum Currency implements Base{
	RMB(1,"￥"),
	EURO(EURO_RMB_EXCHANGE_RATE,"€");
	private float exchangeRate;
	private String unit;
	Currency(float exchangeRate,String unit){
	this.exchangeRate = exchangeRate;
	this.unit = unit;
	}
	public float convertToRMB(float price) {
	return (price*exchangeRate);
	}
	public float convertToEURO(float price) {
	return (price/exchangeRate);
	}
	public float getExchangeRate() {
	return exchangeRate;
	}
	public void setExchangeRate(float exchangeRate) {
	this.exchangeRate = exchangeRate;
	}
	public String getUnit() {
	return unit;
	}
	public void setUnit(String unit) {
	this.unit = unit;
	}
	public String toString() {
	return unit;
	}
}

