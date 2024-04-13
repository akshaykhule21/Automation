package stepDefinations;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();
	
	@Before(order = 0)
	public void launchBrowser(Scenario scenario) {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();
		softAssert.set(new SoftAssert());
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot when scenario is failed.
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); 
			Allure.attachment("failed screenshot", new ByteArrayInputStream(screenshot));
			Allure.step(driver.getCurrentUrl());
//			ExcelWriter.storeIntoExcel();
		}
		if(softAssert!=null) {
			softAssert.get().assertAll();
		}	
	}
	
	public void assertTrue(boolean condition,String message) {
		softAssert.get().assertTrue(condition,message);
	}
	
	public void assertEquals(Boolean actual, Boolean expected,String message) {
		softAssert.get().assertEquals(actual,expected,message);
	}
	
	public void assertEquals(int actual, int expected,String message) {
		softAssert.get().assertEquals(actual,expected,message);
	}
	
	public void assertEquals(String actual, String expected,String message) {
		softAssert.get().assertEquals(actual,expected,message);
	}
	
	public void assertNotEquals(String actual, String expected,String message) {
		softAssert.get().assertNotEquals(actual,expected,message);
	}
	
	public void fail(String message){
		softAssert.get().fail(message);
	}
}