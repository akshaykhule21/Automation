package stepDefinations;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import Repository.ObjPrequotes;
import Util.CommonFunctionsV2;
import Util.RunTimeVars;
import Util.Utility;
import driver.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import testDataManager.Constants;
import testDataManager.TestData;
import testDataManager.TestData;

public class MotorSteps extends TestData{
	private CommonFunctionsV2 CFV2 = new CommonFunctionsV2(DriverFactory.getDriver());
	private RunTimeVars rtv = new RunTimeVars();
	private Utility ut = new Utility(DriverFactory.getDriver());
	
	@Given("Setup data from sheetname {string} and rownumber {int}")
	public void setup_data_from_sheetname_and_rownumber(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		TestData excelDataReader = new TestData();
		excelDataReader.excelDataReader(sheetName, rowNumber);
	}

	@Given("User is on policybazaar car insurance homepage")
	public void user_is_on_policybazaar_car_insurance_home_page() {
		DriverFactory.getDriver().get(Constants.url);
		System.out.println(Constants.url);
		ut.takeScreenshot("car insurance home page");
	}

	@When("user enter car number and click on view prices button")
	public void user_enter_car_number_and_click_on_view_prices_button() {
		if (getRegnum().equalsIgnoreCase("BrandNew")) {			//keyword driven development
			CFV2.clickNewCarBtn();
			Allure.step("Click on buying a new car button.");
		}else if(getRegnum().equalsIgnoreCase("PWCN")) {
			CFV2.enterCarNum("MH88TT5555");
			Allure.step("Invalid registration number entered.");
			CFV2.clickViewPriceBtn();
			Allure.step("Click on view prices button.");
		} else {
			CFV2.enterCarNum(getRegnum());
			Allure.step("Registrarion number entered. i.e. "+getRegnum());
			CFV2.clickViewPriceBtn();
			Allure.step("Click on view prices button.");
		}
	}

	@When("User select City and RTO")
	public void user_select_city_andrto() throws EncryptedDocumentException, InterruptedException, IOException {
		if (ut.isElementPresent(ObjPrequotes.cityrtopage)) {
			CFV2.selectCityandRTo();
		} else {
			CFV2.selectCityandRTo();
		}
	}

	@When("User select make")
	public void user_select_make() {
		CFV2.selectMake();
	}

	@When("User select model")
	public void user_select_model() {
		CFV2.selectModel();
	}

	@When("User select fueltype")
	public void user_select_fueltype() {
		CFV2.selectFuelType();
	}

	@When("User select varient")
	public void user_select_varient() {
		CFV2.selectVarient();
	}

	@When("User select regyear")
	public void user_select_regyear() {
		CFV2.selectRegYear();
	}
}