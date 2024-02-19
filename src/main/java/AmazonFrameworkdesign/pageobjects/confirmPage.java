package AmazonFrameworkdesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonFrameworkdesin.AbstractComponent.AbstractComponent;

public class confirmPage extends AbstractComponent {
	
	WebDriver driver;
	public confirmPage(WebDriver driver) {

     super(driver);
	 this.driver=driver;
      PageFactory.initElements(driver, this);
	}

	@FindBy(css="td h1")
	WebElement confirmmessage;
	
	public String getconfirmation() {
		
		 return confirmmessage.getText();
		
	}
	
	
}
