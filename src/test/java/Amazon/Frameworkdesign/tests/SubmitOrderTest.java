package Amazon.Frameworkdesign.tests;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import AmazonFarmeworkdesign.TestComponents.BaseTest;
import AmazonFrameworkdesign.pageobjects.CartPage;
import AmazonFrameworkdesign.pageobjects.CheckoutPage;
import AmazonFrameworkdesign.pageobjects.Landingpage;
import AmazonFrameworkdesign.pageobjects.OrderPage;
import AmazonFrameworkdesign.pageobjects.ProductCatalogue;
import AmazonFrameworkdesign.pageobjects.confirmPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	
	
	String productname="ZARA COAT 3";

	@Test
	public void SubmitOrder() throws IOException {

        
        //Landingpage landingpage=launchApplication();
		ProductCatalogue productcatalogue=landingpage.loginApplication("anandsharma379@gmail.com", "@Sairam01@");
		List<WebElement>products=productcatalogue.getProductlist();
		productcatalogue.addProductToCart(productname);
		CartPage cartpage=productcatalogue.gotoCartPage();
		Boolean match=cartpage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckoutPage checkoutpage=cartpage.gotocheckOut();
		checkoutpage.selectCountry("india");
		confirmPage confirmationpage=checkoutpage.submit();
		String confirmmessage=confirmationpage.getconfirmation();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		}
	
	
	
	//To verify ZARA COAT 3 is displaying in order page
	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryTest() {
		
		ProductCatalogue productcatalogue=landingpage.loginApplication("anandsharma379@gmail.com", "@Sairam01@");
		OrderPage  orderpage=productcatalogue.gotoOrderHistoryPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productname));
	}

}
