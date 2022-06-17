package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class sample {
	private WebDriver driver;
	@Given("user opens the browser")
	public void user_opens_the_browser() {
	    try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("In open browser Method");
			System.out.println(e);
		}
	}
	
	@When("user enters url {string}")
	public void user_enters_url(String url) {
	    try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		} catch (Exception e) {
			System.out.println("In enter url method");
			System.out.println(e);
		}
	}

	@And("user enters search data in inputbox {string}")
	public void user_enters_search_data_in_inputbox(String data) {
	    try {
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(data);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@And("user press enter")
	public void user_press_enter() {
	    try {
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("Verify whether results are showing or not")
	public void verify_whether_results_are_showing_or_not() throws InterruptedException {
	    try {
	    	Thread.sleep(2000);
			Assert.assertEquals(driver.getTitle(), "java - Google Search");
		} catch (AssertionError e) {
			System.out.println(e);
		}
	}
}
