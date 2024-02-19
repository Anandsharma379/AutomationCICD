package AmazonFrameworkdesin.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AmazonFrameworkdesign.pageobjects.CartPage;
import AmazonFrameworkdesign.pageobjects.OrderPage;

public class AbstractComponent {
	
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {

     super();
	 this.driver=driver;
      PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement Order;
	
	
     public CartPage gotoCartPage() {
		
    	 CartPage cartpage=new CartPage(driver);
    	 cartHeader.click();
    	 return cartpage;
    	 
	}
     
     public OrderPage gotoOrderHistoryPage() {
 		
    	 OrderPage Orderpage=new OrderPage(driver);
    	 Order.click();
    	 return Orderpage;
    	 
	}


	public void waitforElementtoAppear(By findBy) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
public void waitforWebElementtoAppear(WebElement findBy) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitforElementtoDisappear(WebElement ele) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
