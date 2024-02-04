package driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import testDataManager.Constants;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/****
	 * 	This method is used to initialize the thradlocal driver on the basis of given browser
	 *	@return :- will return tldriver.
	****/
	public WebDriver init_driver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		if(Constants.isIncognito) { 	
			options.addArguments("--incognito"); 
		}
	    if(Constants.isHeadless) {
	    	options.addArguments("headless");
		    options.addArguments("disable-gpu");
		    options.addArguments("window-size=1020x960");
	    }
	    if(Constants.browser.equalsIgnoreCase("Chrome")) {
	    	tlDriver.set(new ChromeDriver(options));	    
	    }
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.implicitwait));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		Allure.step("Chrome Browser launched.");
		return getDriver();
	}
	
//	this is used to get the driver with ThreadLocal :- usefull for parallel execution
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}