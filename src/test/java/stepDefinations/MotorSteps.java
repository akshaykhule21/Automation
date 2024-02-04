package stepDefinations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Repository.ObjPrequotes;
import Util.CommonFunctionsV2;
import Util.Utility;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import testDataManager.Constants;
import testDataManager.ExcelDataReader;

public class MotorSteps {
	private CommonFunctionsV2 CFV2=new CommonFunctionsV2(DriverFactory.getDriver());
	private Utility ut=new Utility(DriverFactory.getDriver());

	@Given("Setup data from sheetname {string} and rownumber {int}")
	public void setup_data_from_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException, InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		 ExcelDataReader excelDataReader = new ExcelDataReader();
	     excelDataReader.excelDataReader(sheetName, rowNumber);
	}
	
	@Given("User is on car insurance homepage")
	public void user_is_on_car_insurance_home_page(){
		DriverFactory.getDriver().get(Constants.url);
		ut.takeScreenshot("car insurance home page");
	}
	
	@When("user enter car number and click on view prices button")
	public void user_enter_car_number_and_click_on_view_prices_button(){
		String regnum=ExcelDataReader.getRegnum();
		if( regnum.equalsIgnoreCase("BrandNew")) {
			CFV2.clickNewCarBtn();
		}else {
			CFV2.enterCarNum(regnum);
			Allure.step("Registrarion number entered.");
			CFV2.clickViewPriceBtn();
			Allure.step("Click on view prices button.");
			if(!regnum.equalsIgnoreCase("MH88tt5555"))Allure.step(regnum);	
		}
	}
	
	@When("User select City and RTO")
	public void user_select_city_andrto() throws EncryptedDocumentException, InterruptedException, IOException {
        String city = ExcelDataReader.getCity();
        String rto = ExcelDataReader.getRto(); 
		if(ut.isElementPresent(ObjPrequotes.cityrtopage)) {
			CFV2.selectCityandRTo(city,rto);
			Allure.step(city +" "+ rto +" selected");
		}else {
			CFV2.selectCityandRTo(city,rto);
			Allure.step(city +" "+ rto +" selected");
		}
	}
	
	@When("User select make")
	public void user_select_make() {
		if(ut.isElementPresent(ObjPrequotes.makepage)) {
			String make = ExcelDataReader.getMake();
			CFV2.selectMake(ExcelDataReader.getMake());
			Allure.step(make+" selected");
		}else Assert.fail();
	}
	
	@When("User select model")
	public void user_select_model() {
		if(ut.isElementPresent(ObjPrequotes.modelpage)) {
			String model = ExcelDataReader.getModel();
			CFV2.selectModel(model);
			Allure.step(model+" selected");
		}
	}
	@When("User select fueltype")
	public void user_select_fueltype() {
		if(ut.isElementPresent(ObjPrequotes.fuelpage)) {
			String fueltype = ExcelDataReader.getFuelType();
			CFV2.selectFuelType(fueltype);
			Allure.step(fueltype+" selected");
		}
	}
	
	@When("User select varient")
	public void user_select_varient() {
		if(ut.isElementPresent(ObjPrequotes.varientpage)) {
			String varient = ExcelDataReader.getVariant();
			CFV2.selectVarient(varient);
		}
	}
	
	@When("User select regyear")
	public void user_select_regyear() {
		if(ut.isElementPresent(ObjPrequotes.regyearpage)) {
			String regyear = ExcelDataReader.getRegYear();
			CFV2.selectRegYear(regyear);
		Allure.step(regyear+" selected");
		}
	}
}