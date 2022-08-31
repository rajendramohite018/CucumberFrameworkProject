package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	public WebDriver driver;
	
	public  CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	By cartBag=By.cssSelector("img[alt='Cart'] ");
	By checkOutButton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn=By.xpath("//button[contains(text(),'Apply')]");
	By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");
	By ProductNameCheckOutPage=By.xpath("//p[@class='product-name']");
	
	public void CheckOutItem() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyplaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getchekoutPageProductName() {
		return driver.findElement(ProductNameCheckOutPage).getText();	
	}

}
