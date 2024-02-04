package Util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Repository.ObjPrequotes;
import io.qameta.allure.Allure;
import testDataManager.Constants;


public class Utility {
	private WebDriver driver;
	public Utility(WebDriver driver) {
		this.driver = driver;
	}
	
	//9. for loop
	public void useforloop(By locator,String val) {
	List<WebElement> options = driver.findElements(locator);                   
	for(int i=0;i<options.size();i++) {
		WebElement option = options.get(i);
			if(option.getText().equalsIgnoreCase(val)) {
				click(option);break;
		}
	}
		if(val.equals("2021")) {
			driver.findElement(ObjPrequotes.regmonth).click();
		}
	}
	
	//10. Select class
	public void useSelectClass(By locator,String str) {
		WebElement ele = driver.findElement(locator);
		Select s=new Select(ele);
		try {
			s.selectByVisibleText(str);
		}catch(Exception e) {
			s.selectByValue(str);
		}	
	}
	
	//11. Return text of element
	public void getTexts(By locator){
		List<WebElement> ele = driver.findElements(locator);
		for(int i=0;i<ele.size();i++) {
			WebElement option = ele.get(i);
			System.out.println(option.getText());
			Allure.step(option.getText());
		}
	}
	
	public String returnText(By locator,String attribute) {
		return driver.findElement(locator).getAttribute(attribute); 
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText(); 
	}
	
	//11A. Overloading :- This method returns attribute value.
	public static void returnText(List<WebElement> ele,String attribute){
		for(int i=0;i<ele.size();i++) {
			WebElement option = ele.get(i);
			System.out.println(i+1+") "+option.getAttribute(attribute));
			Allure.step(i+1+") "+option.getAttribute(attribute));
		}
	}

	
	//12. will return that element is present or not
	public boolean isElementPresent( By locator) {
	    try {
	        driver.findElement(locator);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	//13. Click on Element		
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		}catch(ElementNotInteractableException e) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", driver.findElement(locator));
		}
	}
	
	public void click(WebElement ele) {
		try {
		ele.click();
		}catch(ElementNotInteractableException e) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
		}
	}
	
	public void sendKeys(By locator,String str) {
		driver.findElement(locator).sendKeys(str);
	}

	
	public static void useForLoop(List<WebElement> options,String attribute,String val) {
		for(int i=0;i<options.size();i++) {
			WebElement option = options.get(i);
			if(option.getAttribute(attribute).equalsIgnoreCase(val)){
				option.click();break;
			}
		}
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	public void explicitlyWait(By locator,int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean explicitlyWait(String str,int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
		try {
			wait.until(ExpectedConditions.urlContains(str));
			return true;
		}catch(TimeoutException e) {
			return false;
		}
	}
	//Allure screenshot:- This is used to attach screenshot in allure report
	public void takeScreenshot(String str) {
		byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); 
		Allure.attachment(str, new ByteArrayInputStream(screenshot));
	}
		
		
	//---------------------------------------------------------	
		//1. Click on some Element
		public static void clickbyJS(WebDriver driver,WebElement ele) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
		}
		
		//2. Taking a screenshot
		public static void Screenshot(WebDriver driver) throws IOException {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Date d=new Date();
			String filename="Ss_"+d.toString().replace(":","_").replace(" ", "_")+".jpg";
			File dest=new File("C:\\Users\\akshaykhule\\Desktop\\Screenshots\\"+filename);
			FileUtils.copyFile(src, dest);
		}
		
		//3. Capture the title of the webpage
		public String titleByJS(WebElement element) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			String Title=js.executeScript("return document.title").toString();
			return Title;
		}
		
		//4. Refreshing the page
		public void refreshByJS() {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("history.go(0)");
			//driver.navigate().refresh();
		}
		
		//5. Scrolling of the webpage
		public void scrollByJS(int x,int y) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(" + x + "," + y + ")");
		}
		
		//6. Scroll into view 
		public void scrollIntoViewByJS(By locator) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(locator));
		}
		
		//7. Excel
		public static String excel(String sheet,int i) throws EncryptedDocumentException, IOException {
			FileInputStream file=new FileInputStream("C:\\Users\\akshaykhule\\Desktop\\TestData.xlsx");
			String data=WorkbookFactory.create(file).getSheet(sheet).getRow(i).getCell(0).getStringCellValue();
			return data;
		}
		
		public static String excel(String sheet,int i,int j) throws EncryptedDocumentException, IOException {
			FileInputStream file=new FileInputStream("C:\\Users\\akshaykhule\\Desktop\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(file);
			String data = wb.getSheet(sheet).getRow(i).getCell(j).getStringCellValue();
			return data;	
		}
		//8. To generate poupup
		public void generatePopup(String msg) {
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("alert('"+ msg +"');");
		}

}