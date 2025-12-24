package runner;
 
import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Directorio de nuestros archivos .feature
                glue = "steps", // Paquete donde tenemos nuestras clases definiendo los steps
                plugin = { "pretty", "html:target/cucumber-reports.html" })
 
public class TestRunner {

}