package stepDefinations;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks {
	private DriverFactory driverFactory;
	private WebDriver driver;

	@Before(order = 0)
	public void launchBrowser(Scenario scenario) {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver();
	}

//	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot if case is failed.
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); 
			Allure.attachment("failed screenshot", new ByteArrayInputStream(screenshot));
			Allure.step(driver.getCurrentUrl());
		}
		driver.getCurrentUrl();
	}
}