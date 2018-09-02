package SeleniumPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Page_BasePage;
import junit.framework.Assert;

public class Page_TimerTest extends Page_BasePage{

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\chromedriver_win32\\chromedriver.exe");
		//driver = new ChromeDriver();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-infobars");		
		//WebDriver driver = new ChromeDriver(options);
		
	}
	
	public void openTimerURL() {
		//driver.get("http://www.google.com");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");		
	    driver = new ChromeDriver(options);
		driver.get("http://e.ggtimer.com/");
	}
		
	public void checktimerBoxIsDisplayed() {
		if(driver.findElement(By.id("start_a_timer")).isDisplayed()) {
			System.out.println("Timer text box is displayed");
		} else {
			System.out.println("Timer text box is NOT displayed");
		}
	}
	
	
	
	public void checkGoButtonIsDisplayed() {
		if(driver.findElement(By.id("timergo")).isDisplayed()) {
			System.out.println("Go button is displayed");
		} else {
			System.out.println("Go button is NOT displayed");
		}
	}

	public void entertimervalue(int n) {
		driver.findElement(By.id("start_a_timer")).clear();
		driver.findElement(By.id("start_a_timer")).sendKeys(String.valueOf(n));
	}
	
	public void clickongo() {
		driver.findElement(By.id("timergo")).click();
	}
	
	public void checkImFeelingLuckyButtonIsDisplayed() {
		if(driver.findElement(By.name("btnI")).isDisplayed()) {
			System.out.println("I'm Feeling Lucky button is displayed");
		} else {
			System.out.println("I'm Feeling Lucky button is NOT displayed");
		}
	}	
	
	public void welcomemessage(String title) {
	    String title2  = driver.getTitle();
	    System.out.println(title);
	    System.out.println(title2);
	    Assert.assertTrue(driver.getTitle().contains(title));
	}	
	
	
	
	public void validatetimertun(int time) {		
		
		//driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		//System.out.println(time);
		//Alert simpleAlert = driver.switchTo().alert();
		//String alertText = simpleAlert.getText();
		//System.out.println("Alert text is " + alertText);
		//simpleAlert.accept();
		
		
		try {
		    WebDriverWait wait = new WebDriverWait(driver, time);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    alert.accept();
		    Assert.assertTrue(alert.getText().contains("Time Expired!"));
		} catch (Exception e) {
		    //exception handling
		}
		
	}	
	
   public void closethebrowser() {		
		
		driver.close();
		driver.quit();
		
	}	
	
}
