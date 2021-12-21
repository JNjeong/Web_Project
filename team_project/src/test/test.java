package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import model.common.JDBCUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
   public static String compile1 = "[0-9,]+";
   public static String compile2 = "[-]?[0-9,]+";
   static Connection conn;
   static PreparedStatement pstmt;

   public static String change(String column, String pattern) {
      String new_str = "";
      Pattern pat = Pattern.compile(pattern);
      Matcher mat = pat.matcher(column);
      if (mat.find()) {
         new_str = mat.group().replace(",", "");
      }
      return new_str;
   }

   public static void main(String[] args) {
     final String  url = "https://coinpan.com/"; // url
     final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
  	final String WEB_DRIVER_PATH = "G:\\CSE\\WebDevelop_back\\JSP\\JSP_workspace\\team_project\\chromedriver.exe";	

      String COINPREMIUM; // 해외거래소에는 프리미엄이 안붙기 때문에 for문안에서 if문 처리.

      // 드라이버 설정
      try {
         System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
      } catch (Exception e) {
         e.printStackTrace();
      }

      ChromeOptions options = new ChromeOptions(); // 크롬창 안뜨게 하는 옵션
      options.addArguments("headless");

      ChromeDriver driver = new ChromeDriver(options); // 크롬창 실행 but headless 사용 하여 안뜨게!
      driver.get(url); // WebDriver을 해당 url로 이동

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

         System.out.println(MARKETNAME + " " + COINPRICEKOR + " " + COINPRICEENG + " " + COINRATE + " " + COINRATEPCT
               + " " + COINPREMIUM + " " + COINDEAL); //  <-console 확인 필요시!

         
         conn = JDBCUtil.connect();
         try {
            pstmt = conn.prepareStatement("insert into TB_COIN values (?,?,?,?,?,?,?)");
            pstmt.setString(1, MARKETNAME);
            pstmt.setInt(2, Integer.parseInt(COINPRICEKOR));
            pstmt.setInt(3, Integer.parseInt(COINPRICEKOR));
            pstmt.setInt(4, Integer.parseInt(COINPRICEKOR));
            pstmt.setFloat(5, Float.valueOf(COINRATEPCT));
            pstmt.setFloat(6, Float.valueOf(COINPREMIUM ));
            pstmt.setInt(7, Integer.parseInt(COINDEAL));
            pstmt.executeUpdate();
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            JDBCUtil.disconnect(pstmt, conn);
         }

      }
      System.out.println("완료"); // DB insert 완료시.
   }

}