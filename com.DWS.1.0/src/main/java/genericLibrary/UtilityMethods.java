package genericLibrary;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class UtilityMethods {
	public WebDriver driver;
	public Select select;
	public Actions action;
	public WebDriverWait wait;
	public void initObjects() {
		action = new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	public static void selectOption(WebElement element, String option,String value) {
		  Select select = new Select(element);
		  if(option.equals("visibleText")) {
		    select.selectByVisibleText(value);
		  }else if (option.equals("index")) {
		    select.selectByIndex(Integer.parseInt(value));
		  }else if (option.equals("value")) {
		    select.selectByValue(value);
		  } 
		}
	  public void windowSwitch(String title) {
			String parent= driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			for(String i:child) {
				driver.switchTo().window(i);
				if(driver.getTitle().contains(title)) {
					break;
				}
			}
	    }
	
	public String getscreenShot() {
		LocalDateTime dateTime=LocalDateTime.now();
		String dateStamp=dateTime.toString().replaceAll(":", "-");
		String path="./Screenshots/"+dateStamp+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "."+path;
	}
}