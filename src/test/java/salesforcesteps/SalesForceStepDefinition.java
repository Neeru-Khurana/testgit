package salesforcesteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceStepDefinition {
	WebDriver driver;
	@Given("user on LoginPage")
	public void user_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get("https://login.salesforce.com/");
	}
	
	@When("User enters {string} into username field")
	public void user_enters_into_username_field(String username) {
		WebElement email= driver.findElement(By.xpath("//input[@id='username']" ));//email_field
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(email));// check more ExpectedConditions methods
		email.clear();
		email.sendKeys( username);
		System.out.println("user name entered");
	}

	

	@When("User enters {string} into password field")
	public void user_enters_into_password_field(String password) {
		WebElement passwrd=driver.findElement(By.xpath("//input[@id='password']" ));
		passwrd.clear();
		passwrd.sendKeys(password);
		System.out.println("password entered");
	}
	@When("Click on login button")
	public void click_on_login_button() {
		WebElement login=driver.findElement(By.id("Login"));
		login.click();
		System.out.println("login button clicked");
	}

	@Then("error is present with the text {string}")
	public void error_is_present_with_the_text(String string) {
		WebElement error=driver.findElement(By.id("error"));
		error.getText();
   	 System.out.println("error :"+error.getText());
	}

	
		@Then("verify page title as {string}")
	public void verify_page_title_as(String expectedString) {
			String actual=driver.getTitle();
			System.out.println("extracted title is="+actual);
			Assert.assertEquals(actual, expectedString);
				driver.quit();
	}
}

	