package model.common;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class webDriver {
	//드라이버 아이디
	private final String WEB_DRIVER_ID ="webdriver.chrome.driver";											
	//드라이버 경로
	private final String WEB_DRIVER_PATH = "G:\\CSE\\WebDevelop_back\\JSP\\JSP_workspace\\team_project\\chromedriver.exe";	

	public ChromeDriver getDriver(String url) {
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		ChromeOptions options = new ChromeOptions();		//크롬창 안뜨게 하는 옵션 설정
		options.addArguments("headless");
		
		ChromeDriver driver = new ChromeDriver(options);		//headless 사용하여 안뜨게 한 크롬창 실행
		driver.get(url);									//WebDriver를 해당 url로 바로 이동
		
		return driver;
		
	}



}
