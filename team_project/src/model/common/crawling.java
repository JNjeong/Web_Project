package model.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import model.coin.CoinDAO;
import model.coin.CoinVO;

public class crawling {
	
	private static String coinurl="https://coinpan.com/";
	private static String compile1 = "[0-9,]+";
	private static String compile2 = "[-]?[0-9,]+";
	static String COINPREMIUM="";
	
	
     public static void main(String[] args) {
    	 CoinDAO dao = new CoinDAO();
    	 webDriver web = new webDriver();
    	 ChromeDriver driver = web.getDriver(coinurl);
		
    	 for (int i = 1; i < 8; i++) {
    		 String MARKETNAME = driver
    				 .findElement(By.xpath(String.format(
    						 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/th", i)))
    				 .getText();
    		 String COINPRICEKOR = driver
    				 .findElement(By.xpath(String.format(
    						 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/td[1]", i)))
    				 .getText();
    		 String COINPRICEENG = driver
    				 .findElement(By.xpath(String.format(
    						 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/td[2]", i)))
    				 .getText();
    		 String COINRATE = driver
    				 .findElement(By.xpath(String.format(
    						 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/td[3]", i)))
    				 .getText();
    		 String COINRATEPCT = driver.findElement(By.xpath(String.format(
    				 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/td[3]/span", i)))
    				 .getText().replace("%", "");
    		 if (i > 4) {
    			 COINPREMIUM = "0";
    		 } else {
    			 COINPREMIUM = driver.findElement(By.xpath(String.format(
    					 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/td[4]/span", i)))
    					 .getText().replace("%", "");
    		 }
    		 String COINDEAL = driver
    				 .findElement(By.xpath(String.format(
    						 "/html/body/div[4]/div/div[1]/div/div/div[2]/div/div[1]/dl/table/tbody/tr[%d]/td[5]", i)))
    				 .getText();
    		 
    		 COINPRICEKOR = change(COINPRICEKOR, compile1);
    		 COINPRICEENG = change(COINPRICEENG, compile1);
    		 COINDEAL = change(COINDEAL, compile1);
    		 COINRATE = change(COINRATE, compile2);
    		 
    		 //console 확인 필요시!
    		 System.out.println(MARKETNAME + " " + COINPRICEKOR + " " + COINPRICEENG + " " + COINRATE + " " + COINRATEPCT
    				 + " " + COINPREMIUM + " " + COINDEAL);
    		 
    		 
    		 CoinVO vo = new CoinVO();
    		 vo.setMarketname(MARKETNAME);
    		 vo.setCoinpricekor(Integer.parseInt(COINPRICEKOR));
    		 vo.setCoinpriceeng(Integer.parseInt(COINPRICEENG));
    		 vo.setCoinrate(Integer.parseInt(COINRATE));
    		 vo.setCoinratepct(Float.valueOf(COINRATEPCT));
    		 vo.setCoinpremium(Float.valueOf(COINPREMIUM));   		 
    		 vo.setCoindeal(Integer.parseInt(COINDEAL));
    		 
    		 dao.CoinInsert(vo);
    		 
    		 
    	 }
    	 System.out.println("완료");
     }
    	 

     //정규식을 이용한 패턴일치화 작업
     public static String change(String column, String pattern) {
     	String new_str = "";
     	Pattern pat = Pattern.compile(pattern);
     	Matcher mat = pat.matcher(column);
     	if (mat.find()) {
     		new_str = mat.group().replace(",", "");
     	}
     	return new_str;
     }	
    
     
}

