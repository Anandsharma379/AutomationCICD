package AmazonFrameworkdesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonFrameworkdesin.AbstractComponent.AbstractComponent;

public class Landingpage extends AbstractComponent{
	
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	//WebElement useremail=driver.findElement(By.id("userEmail"));
	//pagefactory
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	
			
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement errormessage;
	
	public ProductCatalogue loginApplication(String email,String password) {
		
		useremail.sendKeys("anandsharma379@gmail.com");
		userPassword.sendKeys("@Sairam01@");
		login.click();
		ProductCatalogue productcatalogue=new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
public String geterrorMessage() {
	
	waitforWebElementtoAppear(errormessage);
	return errormessage.getText();

		
		
	}

	
	
	
}
