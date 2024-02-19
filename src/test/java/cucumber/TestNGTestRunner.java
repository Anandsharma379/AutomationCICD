package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber-Testng ,Junit
@CucumberOptions(features="src/test/java/cucumber",glue="AmazonFrameworkdesign.stepDefinition",
monochrome=true,tags="@Regression" ,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	
}
