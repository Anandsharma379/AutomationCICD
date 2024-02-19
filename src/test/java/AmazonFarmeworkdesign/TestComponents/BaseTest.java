package AmazonFarmeworkdesign.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AmazonFrameworkdesign.pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	public WebDriver driver;
	public  Landingpage landingpage;
	
	public WebDriver initilaizeDriver() throws IOException {
		
		
		//properties class
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//AmazonFrameworkdesign//resources//GlobalData.properties");
	    prop.load(fis);
		String browsername=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			ChromeOptions option=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")) {
				option.addArguments("headless");
			}
			 driver=new ChromeDriver(option);
			 driver.manage().window().setSize(new Dimension(1440,900));
		}else if(browsername.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
			//firefox code
		}else if(browsername.equalsIgnoreCase("edge")) {
			
			//edge browser
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		return driver;
	}
public List<HashMap<String, String>>  getJsonDatatoMap(String filepath) throws IOException {
		
		//Read json to string
		String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		//String to HashMap Jackson Databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
		
	}
public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
}
	
	
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchApplication() throws IOException {
		
	 driver=initilaizeDriver();
	 landingpage=new Landingpage(driver);
     landingpage.goTo();
     return landingpage;
     
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		driver.close();
	}
	
	
}
