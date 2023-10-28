package pomPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(partialLinkText = "Log in")
	public WebElement loginlink;
	@FindBy(id = "Email")
	public WebElement emailTextField;
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	@FindBy(xpath = "//input[@value='Log in']")
	public WebElement loginbtn;
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}
	
	public void enterPassword(String password) {
		passwordTextField.sendKeys(password);
	}
}