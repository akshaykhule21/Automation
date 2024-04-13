package stepDefinations;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import Repository.ObjPrequotes;
import Util.CommonFunctionsV2;
import Util.Utility;
import driver.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import testDataManager.Constants;


public class Basic {
	//methods of this class are not in use
	//This class is mapped with Basic.feature where we are passing data from feature file 
	private CommonFunctionsV2 CFV2=new CommonFunctionsV2(DriverFactory.getDriver());
	private Utility ut=new Utility(DriverFactory.getDriver());
	
	@Given("User is on policybazaar car insurance home page")
	public void user_is_on_policybazaar_car_insurance_home_page(){
		DriverFactory.getDriver().get(Constants.url);
	}
	
	String num;
	@When("user enter car number {string} and click on view prices button")
	public void user_enter_car_number(String carnum) throws InterruptedException, IOException {
		if(carnum.equalsIgnoreCase("NEWCAR")) {
			CFV2.clickNewCarBtn();
		}else {
			CFV2.enterCarNum(carnum);
			CFV2.clickViewPriceBtn();	
		}
	}

	@When("User select City {string} and RTO {string}")
	public void user_select_city_and_rto(String city, String rto) throws InterruptedException {
		if(ut.isElementPresent( ObjPrequotes.cityrtopage)) {
//			CFV2.selectCityandRTo(city, rto);
		}
	}

	@When("User select make {string}")
	public void user_select_make(String make) {
		if(ut.isElementPresent( ObjPrequotes.makepage)) {
//			CFV2.selectMake(make);
			}
	}

	@When("User select model {string}")
	public void user_select_model(String model) {
		if(ut.isElementPresent( ObjPrequotes.modelpage)) {
//			CFV2.selectModel(model);
		}
	}

	@When("User select fueltype {string}")
	public void user_select_fueltype(String type) {
		if(ut.isElementPresent( ObjPrequotes.fuelpage)) {
//			CFV2.selectFuelType(type);
		}
	}

	@When("User select varient {string}")
	public void user_select_varient(String varient) {
		if(ut.isElementPresent( ObjPrequotes.varientpage)) {
//			CFV2.selectVarient(varient);
		}
	}

	@When("User select regyear {string}")
	public void user_select_regyear(String year) {
		if(ut.isElementPresent( ObjPrequotes.regyearpage)) {
//			CFV2.selectRegYear(year);
		}
	}
	
	@When("user select registration year {string}")
	public void user_select_registration_year(String year) throws InterruptedException {
//		CFV2.selectRegYear(year);
	}
	
	@And("User select expiry month {string} and day {string}")
	public void user_select_expiry_month_and_day(String month,String day) throws InterruptedException {
//		ut.selectExpiryDate(month, day);
	}
	

}