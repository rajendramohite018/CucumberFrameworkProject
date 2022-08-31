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
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class OfferPageStepDefination {
	
	public PageObjectManager pageObjectManager;
	public String offerPageProductName;
	
	TextContextSetup textContexteSetup;
	
	public OfferPageStepDefination(TextContextSetup textContexteSetup) {
		this.textContexteSetup=textContexteSetup;
	}
	
	@Then("User searched for {string} shortname in offers page to check if product exit with same name")
	public void user_searched_for_something_shortname_in_offers_page_to_check_if_product_exit_with_same_name(
			String shortName) throws Throwable {
		switchToOfferPage(); //calling child window - offer page
		//OfferPage offerPage=new OfferPage(textContexteSetup.driver);
		OfferPage offerPage=textContexteSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
		offerPage.getSearchText(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
		System.out.println("ProductName extracted from Offerpage : " + offerPageProductName);
	}
	
	@Then("^User searched for (.+) short name in offers page to check if product exit with same name$")
	public void user_searched_for_something_short_name_in_offers_page_to_check_if_product_exit_with_same_name(
			String shortName) throws Throwable {
		switchToOfferPage(); //calling child window - offer page
		//OfferPage offerPage=new OfferPage(textContexteSetup.driver);
		OfferPage offerPage=textContexteSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
		offerPage.getSearchText(shortName);
		Thread.sleep(2000);
		offerPageProductName = offerPage.getProductName();
		System.out.println("ProductName extracted from Offerpage : " + offerPageProductName);
	}
	
	public void switchToOfferPage() { // switching ninto offer page
		//pageObjectManager=new PageObjectManager(textContexteSetup.driver);
		LandingPage landingPage=textContexteSetup.pageObjectManager.getLandingPage();
		//LandingPage landingPage=new LandingPage(textContexteSetup.driver);
		landingPage.SelectTopDealPage();
		textContexteSetup.genericUtils.SwitchWindowToChild();
	}
	
	@And("Validate product name matches offer page with landing page")
	public void Validate_product_name_matches_offer_page_with_landing_page() throws Throwable {
		Assert.assertEquals(offerPageProductName, textContexteSetup.landingPageProductName);
		//textContexteSetup.driver.close();
	}
}
