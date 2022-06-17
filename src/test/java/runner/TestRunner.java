package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src//test//resources//Features",
				glue = {"sample"},monochrome = false,
				plugin = {"pretty", "html:target/HtmlReports","json:target/JsonReports/JsonReport.json","junit:target/JunitReports/JunitReport.xml"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
