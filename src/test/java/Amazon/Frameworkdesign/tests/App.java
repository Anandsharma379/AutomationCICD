package Amazon.Frameworkdesign.tests;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {

	public static void main(String[] args)  {

        String productname="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("anandsharma379@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("@Sairam01@");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> product=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=product.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartproduct=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartproduct.stream().anyMatch(cp->cp.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		WebElement checkout = driver.findElement(By.cssSelector(".totalRow button"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", checkout);
		
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		//driver.findElement(By.cssSelector(".action__submit")).click();
		WebElement element = driver.findElement(By.cssSelector(".action__submit"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
		
		String confrmessage=driver.findElement(By.cssSelector("td h1")).getText();
		System.out.println(confrmessage);
		
		Assert.assertTrue(confrmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
		
	
		
		
      
	}

}
