package AmazonFrameworkdesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AmazonFrameworkdesin.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {

     super(driver);
	 this.driver=driver;
      PageFactory.initElements(driver, this);
	}
	
	//pagefactory
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	By result=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryname) {
		Actions a=new Actions(driver);
		a.sendKeys(country,countryname).build().perform();
		
		waitforElementtoAppear(result);
		
		selectCountry.click();
		
	}
	
	public confirmPage submit() {
		
		//submit.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

      js.executeScript("arguments[0].click();", submit);
		
		return new confirmPage(driver);
		
		
	}

}
