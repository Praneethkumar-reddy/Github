package pomPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class WelcomePage {
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Register")
	public WebElement registerLink;
	
	@FindBy(linkText = "Shopping cart")
	public WebElement shoppingCartLink;
	
	@FindBy(linkText = "Wishlist")
	public WebElement wishListLink;
	
	@FindBy(id  = "small-searchterms")
	public WebElement searchTextField;
	
	@FindBy(css = ".button-1.search-box-button")
	public WebElement searchButton;
	
	@FindBy(xpath = "(//img)[1]")
	public WebElement DWSIcon;
	
	@FindBy(xpath = "(//a[contains(text(),'Books')])[1]")
	public WebElement booksTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Computers')])[1]")
	WebElement computersTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Electronics')])[1]")
	public WebElement electronicsTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Apparel & Shoes')])[1]")
	public WebElement apparelShoesTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Digital downloads')])[1]")
	public WebElement digitalDownloadsTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Jewelry')])[1]")
	public WebElement jewelryTab;
	
	@FindBy(xpath = "(//a[contains(text(),'Gift Cards')])[1]")
	public WebElement giftCardsTab;
	
	@FindBy(id = "newsletter-email")
	public WebElement newsLetterEmailTextField;
	
	@FindBy(id = "newsletter-subscribe-button") 
	public WebElement newsLetterSubscribeButton;
	
	@FindBy(xpath = "//label[text()='Excellent']")
	public WebElement excellentRadioButton;
	
	@FindBy(xpath = "//label[text()='Good']")
	public WebElement goodRadioButton;
	
	@FindBy(xpath = "//label[text()='Poor']")
	public WebElement poorRadioButton;
	
	@FindBy(xpath = "//label[text()='Very bad']")
	public WebElement veryBadRadioButton;
	
	@FindBy(id = "vote-poll-1")
	public WebElement voteButton;
}
