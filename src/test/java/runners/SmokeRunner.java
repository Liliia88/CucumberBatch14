package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //feautures we use to provide the path of all the feature files
        features = "/Users/liliya.khusainova/Documents/Cucumber/CucumberBatch14/src/test/resources/features",
        glue = "steps"
)

public class SmokeRunner {

}
