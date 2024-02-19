package AmazonFrameworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AmazonFrameworkdesin.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	//List<WebElement> product=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productBy=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	By openCart=By.cssSelector("[routerlink='/dashboard/cart']");
	
	public List<WebElement> getProductlist() {
		
		waitforElementtoAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productname) {
		
		WebElement prod=getProductlist().stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCart(String productname) {
		
		
		WebElement prod=getProductByName(productname);
		prod.findElement(addToCart).click();
		waitforElementtoAppear(toastmessage);
		waitforElementtoDisappear(spinner);
		
	}
	
	

	
	
	
	
	
	
	
}
