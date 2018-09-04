package SeleniumPages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.Page_BasePage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


public class Page_TimerTest extends Page_BasePage{

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\softwares\\chromedriver_win32\\chromedriver.exe");
			
	}
	
	public void openTimerURL() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");		
	    driver = new ChromeDriver(options);
		driver.get("http://e.ggtimer.com/");
	}
		
	public void checktimerBoxIsDisplayed() {
		if(driver.findElement(By.id("start_a_timer")).isDisplayed()) {
			System.out.println("Timer text box is displayed");
		} else {
			System.out.println("Timer text box is not displayed");
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
	
	
	public void welcomemessage(String title) {
	    String title2  = driver.getTitle();
	    System.out.println(title);
	    System.out.println(title2);
	    Assert.assertTrue(driver.getTitle().contains(title));
	}	
	
	
	public void validatetimertun(int time) {		
		
			
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


public void runTimer()
 {
	 long startTime=0;

     try {       

            String prevText = new String();
            String currText = new String();
            int i = 25;
            FluentWait<WebDriver> Wait = new FluentWait<WebDriver>(driver);
            Wait.withTimeout(25, TimeUnit.SECONDS);
            Wait.pollingEvery(1, TimeUnit.MILLISECONDS);
            Wait.ignoring(NoSuchElementException.class);
            startTime = System.currentTimeMillis();       

            Wait.until(new Function<WebDriver, Boolean>() {

            				public Boolean apply(WebDriver driver) {

            				System.out.println("Current Window State       : "

                			+ String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));

            				return String

            						.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))

            						.equals("complete");

            				} });

            //Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("progressText"), "25 seconds")); 
            prevText = driver.findElement(By.id("progressText")).getText();
            long timeLapsed = System.currentTimeMillis();
            while(driver.findElement(By.id("progressText")).isDisplayed())
            {   
            	
            	long loopTimeStart =  System.currentTimeMillis();
            	currText = driver.findElement(By.id("progressText")).getText();
            	//System.out.println(currText);
               	if (currText.equals(prevText))
                                {

                         			continue;

                                }

                   else

                   {

                       long changeTime = System.currentTimeMillis();
                         System.out.println(currText);
                         System.out.println("Time Lapsed : " + (changeTime - timeLapsed) );   
                         
                         if (currText.contains(i + "second"))                        	 
                         {
                        	 System.out.println("Current counter matches: "+ currText +" : "+ i + "seconds");
                        	 
                         }
                         else
                         {
                        	 System.out.println("Current counter does not matches: "+ currText +" : "+ i + "seconds");
                         }
                                              
                        //Assert.assertTrue("Test failed", Math.abs(1000 - (changeTime - timeLapsed)) < 50);
                         
                         timeLapsed = changeTime;        
                         prevText = currText;                
                         long loopTimeEnds =  System.currentTimeMillis();
                         System.out.println("Loop time : " + (loopTimeStart - loopTimeEnds ) ); 
                         i = i-1;
                   }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Total Time Lapsed : " + (startTime - endTime ) );       
     }

      catch (Exception e) {

         //exception handling     
            long endTime = System.currentTimeMillis();
            System.out.println("Total Time Lapsed : " + (startTime - endTime ) );
            
            if ((startTime - endTime ) < 2500)
            {
            	System.out.println("Test Failes as Total tme lapsed is less than 2500");
            }
      }
     closethebrowser();
   	 
  }
   public void closethebrowser() {		
		
		driver.close();
		driver.quit();
		
	}	
	
}
