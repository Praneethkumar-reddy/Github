package genericLibrary;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
public class BaseTest extends UtilityMethods {
	
	@Parameters("browserName")
	@BeforeClass
	public void browserSetup(@Optional("chrome") String browserName) {
		if(browserName.contains("msedge")) {
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			 driver=new ChromeDriver();
		     driver.manage().window().maximize();
		     driver.get("https://demowebshop.tricentis.com/");
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else 
			System.out.println("give valid browser name");
	}
	@AfterClass
	public void browserTearDown() {
		driver.quit();
	}
}