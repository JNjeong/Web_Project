package model.VO;

public class CoinVO {
	private String marketname;
	private int coinpricekor;
	private int conpriceeng;
	private int coinrate;
	private int coinratepct;
	private int coinpremium;
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
	public int getConpriceeng() {
		return conpriceeng;
	}
	public void setConpriceeng(int conpriceeng) {
		this.conpriceeng = conpriceeng;
	}
	public int getCoinrate() {
		return coinrate;
	}
	public void setCoinratepct(int coinratepct) {
		this.coinratepct = coinratepct;
	}
	public int getCoinratepct() {
		return coinratepct;
	}
	public void setCoinrate(int coinrate) {
		this.coinrate = coinrate;
	}
	public int getCoinpremium() {
		return coinpremium;
	}
	public void setCoinpremium(int coinpremium) {
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
		return "CoinVO [coinname=" + marketname + ", coinpricekor=" + coinpricekor + ", conpriceeng=" + conpriceeng
				+ ", coinrate=" + coinrate + ", coinratepct=" + coinratepct + ", coinpremium=" + coinpremium
				+ ", coindeal=" + coindeal + "]";
	}
	
	
	
	
}
