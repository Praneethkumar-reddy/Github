package testScripts;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import genericLibrary.ExcelRead;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
@Listeners(genericLibrary.ListenersImplementation.class)
public class TC003_AddToCartTest extends BaseTest {
	@Test(dataProvider = "testdata")
	public void login(String userName,String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.cssSelector("a[class='ico-login']")).click();
        driver.findElement(By.id("Email")).sendKeys(userName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.partialLinkText("Apparel")).click();
       
        driver.findElement(By.xpath("//a[text()='Blue and green Sneaker']/parent::h2/following-sibling::div[3]/div[2]/input")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("add-to-cart-button-28")).click();
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	}
	@DataProvider(name="testdata")
	public Object[][] testdata() throws EncryptedDocumentException, IOException{
		return ExcelRead.multipleRead("login");
	}	
}