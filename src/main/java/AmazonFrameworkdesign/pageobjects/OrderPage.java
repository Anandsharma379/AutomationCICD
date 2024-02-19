package AmazonFrameworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonFrameworkdesin.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productnames;
	
	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public Boolean verifyOrderDisplay(String productname) {
		Boolean match=productnames.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
		return match;
	}	
	
	
}
