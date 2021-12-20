package model.coin;

public class CoinVO {
	private String marketname;
	private int coinpricekor;
	private int coinpriceeng;
	private int coinrate;
	private double coinratepct;
	private double coinpremium;
	private int coindeal;
	
	public String getMarketname() {
		return marketname;
	}
	public void setMarketname(String marketname) {
		this.marketname = marketname;
	}
	public int getCoinpricekor() {
		return coinpricekor;
	}
	public void setCoinpricekor(int coinpricekor) {
		this.coinpricekor = coinpricekor;
	}
	public int getCoinpriceeng() {
		return coinpriceeng;
	}
	public void setCoinpriceeng(int coinpriceeng) {
		this.coinpriceeng = coinpriceeng;
	}
	public int getCoinrate() {
		return coinrate;
	}
	public void setCoinratepct(double coinratepct) {
		this.coinratepct = coinratepct;
	}
	public double getCoinratepct() {
		return coinratepct;
	}
	public void setCoinrate(int coinrate) {
		this.coinrate = coinrate;
	}
	public double getCoinpremium() {
		return coinpremium;
	}
	public void setCoinpremium(double coinpremium) {
		this.coinpremium = coinpremium;
	}
	public int getCoindeal() {
		return coindeal;
	}
	public void setCoindeal(int coindeal) {
		this.coindeal = coindeal;
	}
	@Override
	public String toString() {
		return "CoinVO [coinname=" + marketname + ", coinpricekor=" + coinpricekor + ", conpriceeng=" + coinpriceeng
				+ ", coinrate=" + coinrate + ", coinratepct=" + coinratepct + ", coinpremium=" + coinpremium
				+ ", coindeal=" + coindeal + "]";
	}
	
	
	
	
}
