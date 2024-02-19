package Amazon.Frameworkdesign.tests;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AmazonFarmeworkdesign.TestComponents.BaseTest;
import AmazonFarmeworkdesign.TestComponents.Retry;
import AmazonFrameworkdesign.pageobjects.CartPage;
import AmazonFrameworkdesign.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {

        String productname="ZARA COAT 3";
        landingpage.loginApplication("anandsharma379@gmail.com", "@Sairam01@");
        Assert.assertEquals("Login Successfully1", landingpage.geterrorMessage());
		
		
  }
	@Test(dataProvider="getData",groups="purchase")
	public void ProductErrorValidation(HashMap<String,String> input) throws IOException {

       // String productname="ZARA COAT 3";
        //Landingpage landingpage=launchApplication();
		ProductCatalogue productcatalogue=landingpage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement>products=productcatalogue.getProductlist();
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartpage=productcatalogue.gotoCartPage();
		Boolean match=cartpage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email","anandsharma379@gmail.com");
//		map.put("password","@Sairam01@");
//		map.put("product","ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email","anshika@gmail.com");
//		map1.put("password","Iamking@000");
//		map1.put("product","ADIDAS ORIGINAL");
		
		List<HashMap<String,String>> data=getJsonDatatoMap(System.getProperty("user.dir")+"//src//test//java//AmazonFrameworkdesign//data//PurchaseOrder.json");
		
		
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

//	@DataProvider
//	public Object[][] getData() {
//		
//		return new Object[][] {{"anandsharma379@gmail.com","@Sairam01@","ZARA COAT 3"},{"anshika@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
//	}

}
