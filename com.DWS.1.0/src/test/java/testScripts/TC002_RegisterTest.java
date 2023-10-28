package testScripts;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import genericLibrary.ExcelRead;
@Listeners(genericLibrary.ListenersImplementation.class)
public class TC002_RegisterTest extends BaseTest{
	@Test(dataProvider = "testdata")
	public void register(String firstname,String lastname, String email,String password) {
		driver.findElement(By.cssSelector("a[class='ico-register']")).click();
        driver.findElement(By.cssSelector("label[for='gender-male']")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstname);
        driver.findElement(By.id("LastName")).sendKeys(lastname);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
	}
	@DataProvider(name="testdata")
	public Object[][] testdata() throws EncryptedDocumentException, IOException{
		return ExcelRead.multipleRead("register");
	}
}