package Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ObjPrequotes {

	public static By carnum=By.id("regNoTextBox");
	public static By viewpricesbtn1=By.id("spanGetQuote");
	public static By buynewcarbtn=By.xpath("//a[contains(text(),'Buying a new car')]");
	public static By prequotesheading=By.xpath("//h3//span[2]");
	public static By cityrtopage=By.id("dvRTO");
	public static By makepage=By.id("dvMake");
	public static By modelpage=By.id("dvModel");
	public static By fuelpage=By.id("dvFuelType");
	public static By varientpage=By.xpath("//span[contains(text(),'Variant')]");
	public static By regyearpage=By.id("dvRegYear");
	public static By leadformpage=By.xpath("//div[@class='textinput']");
	
	public static By makes=By.xpath("//li[contains(@class,'col')]/span");
	public static By models=By.xpath("//div[@id='modelScroll']//b");
	public static By fueltypes=By.xpath("//div[@class='row']/li/span");
	public static By varients=By.xpath("//div[@class='row']/li/span");
	public static By regyears=By.xpath("//div[@class='row']//span/b");

	public static By city=By.xpath("//li/span[contains(@id,'sp')]");
	public static By rto=By.xpath("//span[@class='active']/parent::li//following-sibling::div[2]//span");
	public static By mmfvtext=By.xpath("//li[contains(@class,'col')]//b");
	public static By mmfv=By.xpath("//li[contains(@class,'col')]//b/parent::span/parent::li");
//	public static By makes=By.xpath("//li[contains(@class,'col')]//b");
//	public static By mmfv =By.xpath("//li[contains(@class,'col')]//span");
	public static By brandnewonyear=By.xpath("//b[text()='Brand New Car']");
	public static By regmonth=By.xpath("//span[contains(text(),'Sep')]");			 //only if the regyear is 2021
	
	public static By name=By.id("name");
	public static By email=By.id("email");
	public static By mobileno=By.id("mobileNo");
	public static By viewpricesbtn2=By.id("btnLeadDetails");
}
