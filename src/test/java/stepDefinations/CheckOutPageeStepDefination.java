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
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import utils.TextContextSetup;

public class CheckOutPageeStepDefination {

	public WebDriver driver;
	public String checkOutPageProductName;
	public CheckOutPage checkOutPage;
	TextContextSetup textContexteSetup;
	
	public CheckOutPageeStepDefination(TextContextSetup textContexteSetup) {
		this.textContexteSetup=textContexteSetup;
		this.checkOutPage=textContexteSetup.pageObjectManager.checkOutPage();
	}
	
	 @Then("^User procceds to checkOut and validate the (.+) items in checkout Page$")
	    public void user_procceds_to_checkout_and_validate_the_items_in_checkout_page(String shortname) throws Throwable {
	       
		 checkOutPage.CheckOutItem();
		 Thread.sleep(2000);
		 checkOutPageProductName =checkOutPage.getchekoutPageProductName().split("-")[0].trim();
		 System.out.println("ProductName extracted from checkOutPage : " +checkOutPageProductName);
		 Assert.assertEquals(checkOutPageProductName, textContexteSetup.landingPageProductName);
	    }

	    @And("^verify user has ability to enter promocode and place the order$")
	    public void verify_user_has_ability_to_enter_promocode_and_place_the_order() throws Throwable {
	    	 //first add CheckOutPage into PageObjectManager then you can use below text
			 
			 Assert.assertTrue(checkOutPage.verifyPromoBtn());
			 Assert.assertTrue(checkOutPage.verifyplaceOrder());
			 
	    }
	

}
