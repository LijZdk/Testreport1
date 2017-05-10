package MavenTest.Testreport;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AppTest {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home home;
	
	
	@BeforeClass
	//@Before(priority = 1, enabled = true)
	public void setup(){
		// where to create the report file
		report = new ExtentReports(
				"C:\\Users\\Administrator\\workspace\\Testreport\\automationreport.html",
				true);
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Administrator\\Desktop\\selenium\\SeleniumFiles\\Selenium\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\selenium\\SeleniumFiles\\Selenium\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
		home = new Home(driver);
	}
	
	// pass scenario
	@Test(priority = 1, enabled = true)
	public void AmazonTest1() throws IOException{
		
		report = new ExtentReports(
				"C:\\Users\\Administrator\\workspace\\Testreport\\automationreport.html",
				true);
		test = report.startTest("Scenerio 1");
		
		
		String homepage = home.getTitle();
		
		
		if(homepage.equals("Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more")){
			test.log(LogStatus.PASS, "Testing completed: proceeded to checkout");
		}else{
			test.log(LogStatus.FAIL, "Test incompete: ");
		}
		
		report.endTest(test);
		report.flush();
	}
	
	// Fail scenario
	// make this fail to see the screenshot output
	@Test(priority = 2, enabled = true)
	public void verifySearchBox() throws IOException {

		
		test = report.startTest("Searching");
		WebElement signInbtn = driver.findElement(By.id("twotabsearchtextbox"));
		if(signInbtn !=null){
			signInbtn.sendKeys("Apple iPhone 6 UK Smartphone - Gold (16GB) (Certified Refurbished)");
			home.clickSubmitTXT();
			test.log(LogStatus.PASS, "verify logo");
			
		}else{
			test.log(LogStatus.FAIL, "verify logo");
			
		}
		
		report.endTest(test);
		report.flush();
		
	}
	
	@Test(priority = 3, enabled = true)
	public void FiIphone(){


			home.clickIphneLink();
			WebElement proceeding = driver.findElement(By.id("add-to-cart-button"));
			
			if(proceeding != null){
				test.log(LogStatus.PASS, "verify logo");
				home.clickbasketLink();
			
			}else{
				test.log(LogStatus.FAIL, "Test incompete: ");
			}
			
		report.endTest(test);
		report.flush();
	
	}
	
	@Test(priority = 4, enabled = true)
	public void BasketIphone() throws IOException{
		
		WebElement proceeed = driver.findElement(By.id("hlb-ptc-btn-native"));
		
		if(proceeed != null){
			test.log(LogStatus.PASS, "verify logo");
		}else{
			test.log(LogStatus.FAIL, "Test incompete: ");
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"C:\\Users\\Administrator\\workspace\\Testreport\\img.jpg"));
			String image = test.addScreenCapture(
				"C:\\Users\\Administrator\\workspace\\Testreport\\img.jpg");
			test.log(LogStatus.FAIL, "verify logo of the application", image);
		}
		
		report.endTest(test);
		report.flush();
		driver.quit();
	}
		
	}
		
