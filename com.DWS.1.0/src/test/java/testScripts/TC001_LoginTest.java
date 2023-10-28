package testScripts;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibrary.BaseTest;
import genericLibrary.ExcelRead;
import pomPage.LoginPage;
@Listeners(genericLibrary.ListenersImplementation.class)
public class TC001_LoginTest extends BaseTest {
	@Test(dataProvider = "testdata")
	public void login(String userName,String password ) {
			LoginPage loginPage=new LoginPage(driver);
		    loginPage.loginlink.click();
	        loginPage.emailTextField.sendKeys(userName);
	        loginPage.enterPassword(password);
	        loginPage.loginbtn.click();
	}
	@DataProvider(name="testdata")
	public Object[][] testdata() throws EncryptedDocumentException, IOException{
		return ExcelRead.multipleRead("login");
	}
}