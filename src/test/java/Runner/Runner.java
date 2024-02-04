package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import testDataManager.RunManager;

@CucumberOptions(
		features="src/test/java/features",													
		glue="stepDefinations",								
		dryRun=false,		
		tags="@PWCN",
		monochrome=true,								
		plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}	
		)
public class Runner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=false)
	public Object [][] scenarios(){
		if(RunManager.isEnabledPWCN) return super.scenarios();	
		else return new Object[0][0]; //returning empty array to skip this class from execution	
	}
}