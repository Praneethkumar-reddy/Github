package extentReports;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class WorkingWithExtentReports {
	static WebDriver driver;
	public static void main(String[] args) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Reports/firstReport.html");
		ExtentReports report=new ExtentReports();
		report.attachReporter(reporter);
		ExtentTest test=report.createTest("LoginTest");
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        test.log(Status.INFO, "webpage is loaded");
        driver.findElement(By.cssSelector("a[class='ico-login']")).click();
        driver.findElement(By.id("Email")).sendKeys("praneethkumarr321@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Paneeth@123");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        try {
        if(driver.findElement(By.className("ico-logout")).isDisplayed()) {
        	System.out.println("logged in");
        	test.log(Status.PASS, "logged in");
        }}
        catch(Exception e) {
        	System.out.println("not logged in");
        	test.log(Status.FAIL, "not logged in");
        	test.fail(MediaEntityBuilder.createScreenCaptureFromPath(getscreenShot()).build());
        }
        driver.close();
        report.flush();
	}
	public static String getscreenShot() {
		LocalDateTime dateTime=LocalDateTime.now();
		String dateStamp=dateTime.toString().replaceAll(":", "-");
		String path="./Screenshots/"+dateStamp+".png";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File temp=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "."+path;
	}
}