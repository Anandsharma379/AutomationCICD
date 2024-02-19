package AmazonFrameworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonFrameworkdesin.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	//pagefactory
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	public CheckoutPage gotocheckOut() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

      js.executeScript("arguments[0].click();", checkout);
		return new CheckoutPage(driver);
	}

	public Boolean verifyProductDisplay(String productname) {
		Boolean match=cartproducts.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
		return match;
	}	
	
	
}
