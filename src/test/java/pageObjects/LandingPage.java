package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	
	public  LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4[class='product-name']");
	By TopDeals=By.linkText("Top Deals");
	By increment=By.xpath("//a[contains(text(),'+')]");
	By addToCart=By.xpath("//button[contains(text(),'ADD TO CART')]");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText(String name) {
		driver.findElement(search).getText();	
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();	
	}
	public void SelectTopDealPage() {
		driver.findElement(TopDeals).click();	
	}
	public String getLanidngPageTile() {
		return driver.getTitle();
	}
	
	public void incrementQuantity(int quntity) {
		int i = quntity-1;
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addCartdetails() {
		driver.findElement(addToCart).click();
	}
	
}
