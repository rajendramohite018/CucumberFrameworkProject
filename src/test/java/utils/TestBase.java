package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		//below code use for to pass chrom value from cmd maven or global properties file
		String browser_properties = prop.getProperty("browser");
		String 	browser_maven=System.getProperty("browser");
		
		//result=testcondition ? value1 : value2
		String browser=browser_maven!=null ? browser_maven : browser_properties;
		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome"))  // when need to pass from mvn cmd chrom value use this
			{
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\002YUF744\\IdeaProjects\\CucumberFrameworkProject\\BrowserDriver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			if (browser.equalsIgnoreCase("firefox"))  //it will work as case sensitive
			{
				//firefox code here
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\002YUF744\\IdeaProjects\\CucumberFrameworkProject\\BrowserDriver\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
			}
			if (browser.equalsIgnoreCase("edge"))  //it will work as case sensitive
			{
				//firefox code here
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\002YUF744\\IdeaProjects\\CucumberFrameworkProject\\BrowserDriver\\msedgedriver.exe");
				driver=new EdgeDriver();
				driver.manage().window().maximize();
			}
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(url);
		}

		return driver;
	}
}
