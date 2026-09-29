package testrunner2;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src/test/resources/Features2",
		glue = "stepdefenition2",
		monochrome = true)
public class Test {

}
