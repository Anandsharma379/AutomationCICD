package AmazonFrameworkdesign.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AmazonFarmeworkdesign.TestComponents.BaseTest;
import AmazonFrameworkdesign.pageobjects.CartPage;
import AmazonFrameworkdesign.pageobjects.CheckoutPage;
import AmazonFrameworkdesign.pageobjects.Landingpage;
import AmazonFrameworkdesign.pageobjects.ProductCatalogue;
import AmazonFrameworkdesign.pageobjects.confirmPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	
	
	public Landingpage landingpage;
	ProductCatalogue productcatalogue;
	confirmPage confirmationpage;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		
		landingpage=launchApplication();
		
	}
	
	@Given("^Login with username (.+) and password (.+)$") 
	public void Login_username_password(String username,String password) {
		
		 productcatalogue=landingpage.loginApplication(username,password);
		
	}
	
	 @When("^I add product (.+) to Cart$")
	 public void I_add_product_to_cart(String productname) {
		 
		 List<WebElement>products=productcatalogue.getProductlist();
		 productcatalogue.addProductToCart(productname);
	 }
	 
	 @And("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_order(String productname) {
		 
		   CartPage cartpage=productcatalogue.gotoCartPage();
			Boolean match=cartpage.verifyProductDisplay(productname);
			Assert.assertTrue(match);
			CheckoutPage checkoutpage=cartpage.gotocheckOut();
			checkoutpage.selectCountry("india");
			confirmationpage=checkoutpage.submit();
	 }
	 
	 @Then("{string} message is displayed on confirmation page")
	 public void message_displayed_on_confirmation(String string) {
		
		 String confirmmessage=confirmationpage.getconfirmation();
			Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));
			driver.close();
		 
	 }
		
	 @Then("{string} message is displayed")
	 public void something_message_is_displayed(String str) {
		 
		 Assert.assertEquals(str, landingpage.geterrorMessage());
		 driver.close();
		 }
			 

	 
	

}
