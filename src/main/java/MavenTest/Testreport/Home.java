package MavenTest.Testreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {

	
	WebDriver driver;
	
	//By title = By.linkText("Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");
	By SearchBar = By.id("twotabsearchtextbox");
	By submit = By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[2]/div/input");
	By IphneLink = By.xpath("//*[@id=\"result_2\"]/div/div[3]/div[1]/a/h2");
	By basketLink = By.id("add-to-cart-button");
	By toCheckOut = By.id("hlb-ptc-btn-native");
	
	
	public Home(WebDriver driver){
		
		this.driver = driver;
		
	}
	
	public void getSearchBar(String keys){
		
		driver.findElement(SearchBar).sendKeys(keys);
	}
	
	public String getTitle(){
		
		return driver.getTitle();
	}
	
	public void clickSubmitTXT(){
		
		driver.findElement(submit).click();
	}
	
	public void clickIphneLink(){
		
		driver.findElement(IphneLink).click();
	}
	
	public void clickbasketLink(){
		
		driver.findElement(basketLink).click();
		
	}
	
	public String getCheckOutLink(){
		
		return driver.findElement(toCheckOut).getText();
	}
	
	
	
}
