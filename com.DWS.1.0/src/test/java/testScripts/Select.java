package testScripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;

public class Select extends BaseTest {

	    @Test
		public void select() throws InterruptedException {
	    	driver.findElement(By.partialLinkText("Twitter")).click();
	    	windowSwitch("nopCommerce (@nopCommerce) / X");
	    	driver.findElement(By.xpath("//span[text()='Settings']")).click();
	    	Thread.sleep(2000);
	    }
	  
}