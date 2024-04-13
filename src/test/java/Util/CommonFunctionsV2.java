package Util;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Repository.ObjPrequotes;
import driver.DriverFactory;
import testDataManager.TestData;

public class CommonFunctionsV2 extends TestData{
	private WebDriver driver;
	private Utility ut = new Utility(DriverFactory.getDriver());
	public CommonFunctionsV2(WebDriver driver) {
		this.driver = driver;
	}

	public void enterCarNum(String carnum) {
		ut.sendKeys(ObjPrequotes.carnum,carnum);	
	}
		
	public void clickViewPriceBtn() {
		ut.click(ObjPrequotes.viewpricesbtn1);
	}
	
	public void clickNewCarBtn() {
		ut.click(ObjPrequotes.buynewcarbtn);
	}
	
	public String getprequotesheading() {
		return ut.getText(ObjPrequotes.prequotesheading);
	}
		
	public void selectCityandRTo() throws InterruptedException {
		ut.useforloop(ObjPrequotes.city, getCity());	
		Thread.sleep(300);
		ut.useforloop(ObjPrequotes.rto,getRto());
	}

	public void selectMake() {
		List<WebElement> options = driver.findElements(ObjPrequotes.makes);
		ut.useForLoop(options, "class", getMake());
	}
	
	public void selectModel() {
		ut.useforloop(ObjPrequotes.models,getModel());
	}
		
	public void selectFuelType() {
		List<WebElement> s1 = driver.findElements(ObjPrequotes.fueltypes);
		ut.useForLoop(s1, "id", getFuelType());
	}
	
	public void selectVarient() {
		ut.click(ObjPrequotes.varients);
	}
	
	public void selectRegYear() {
		ut.useforloop(ObjPrequotes.regyears,getRegYear());	
	}
	
	public void setName(String name) {
		ut.sendKeys(ObjPrequotes.name,name);
	}
	
	public void setEmail(String mail) {
		WebElement ele = driver.findElement(ObjPrequotes.email);
		System.out.println("passed.");
		if(ele.getAttribute("class").equalsIgnoreCase("filled")) {
			}else {
				ele.sendKeys(mail);
			}
		}
	
	public void setMoNo(String number) {
		WebElement ele = driver.findElement(ObjPrequotes.mobileno);
		if(ele.getAttribute("class").equalsIgnoreCase("filled")) {
			}else {
				ele.sendKeys(number);
			}				
		}
	
	public void clickViewPricesBtn2() {
		ut.click(ObjPrequotes.viewpricesbtn2);
	}

}