package utils;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SwitchWindowToChild() {
		String ParentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tab = new ArrayList<>(allWindows);
		driver.switchTo().window(tab.get(1));
	}
}
