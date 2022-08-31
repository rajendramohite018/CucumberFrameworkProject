package stepDefinations;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class LandingPageStepDefination {

	public WebDriver driver;
	public String offerPageProductName;
	public String landingPageProductName;
	TextContextSetup textContexteSetup;
	LandingPage landingPage;

	public LandingPageStepDefination(TextContextSetup textContexteSetup) {
		this.textContexteSetup = textContexteSetup;
		this.landingPage = textContexteSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_greencart_landing_page() throws Throwable {
		textContexteSetup.testBase.WebDriverManager();
		Assert.assertTrue(landingPage.getLanidngPageTile().contains("GreenKart"));
		 
	}

	@When("User searched with shortname {string} and extracted actual name of product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws Throwable {

		landingPage.searchItem(shortName);
		// textContexteSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		textContexteSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("ProductName extracted from homepage : " + textContexteSetup.landingPageProductName);
	}

	@When("^User searched with short name (.+) and extracted actual name of product$")
	public void user_searched_with_short_name_and_extracted_actual_name_of_product(String shortName) throws Throwable {

		landingPage.searchItem(shortName);
		// textContexteSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		textContexteSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("ProductName extracted from homepage : " + textContexteSetup.landingPageProductName);
	}
	
	@And("^Added \"([^\"]*)\" items of the selected product to cart$")
    public void added_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addCartdetails();
    }

}
