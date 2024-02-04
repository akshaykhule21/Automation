package Util;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Repository.ObjPrequotes;
import driver.DriverFactory;

public class CommonFunctionsV2 {
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
		
	public void selectCityandRTo(String city,String Rto) throws InterruptedException {
		ut.useforloop(ObjPrequotes.city, city);	
		Thread.sleep(300);
		ut.useforloop(ObjPrequotes.rto,Rto);
	}

	public void selectMake(String make) {
		List<WebElement> options = driver.findElements(ObjPrequotes.makes);
		ut.useForLoop(options, "class", make);
	}
	
	public void selectModel(String model) {
		ut.useforloop(ObjPrequotes.models,model);
	}
		
	public void selectFuelType(String type) {
		List<WebElement> s1 = driver.findElements(ObjPrequotes.fueltypes);
		ut.useForLoop(s1, "id", type);
	}
	
	public void selectVarient(String varient) {
		ut.click(ObjPrequotes.varients);
	}
	
	public void selectRegYear(String year) {
		ut.useforloop(ObjPrequotes.regyears,year);	
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