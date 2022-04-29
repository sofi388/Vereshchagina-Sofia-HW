package hw5.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/AllTest.feature"},
        glue = {"hw5.steps"}
        // tags = "@first"
        // tags = "@second"
        // tags = "@first"
)
public class AllTests extends AbstractTestNGCucumberTests {
}
