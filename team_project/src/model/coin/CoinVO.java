package model.coin;

public class CoinVO {
	private String marketname;
	private int coinpricekor;
	private int coinpriceeng;
	private int coinrate;
	private float coinratepct;
	private float coinpremium;
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
	public void setCoinrate(int coinrate) {
		this.coinrate = coinrate;
	}
	public float getCoinratepct() {
		return coinratepct;
	}
	public void setCoinratepct(float coinratepct) {
		this.coinratepct = coinratepct;
	}
	public float getCoinpremium() {
		return coinpremium;
	}
	public void setCoinpremium(float coinpremium) {
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