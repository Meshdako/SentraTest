package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.NonNull;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    
    // WebDriverWait se usa para poner esperas explícitas en los elementos web
    WebDriverWait wait;

    // Creamos nuestro constructor sin parámetros, así el driver se crea solo una vez.
    public BasePage() {
        if( driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }
    
    // Método estático para cerrar la instancia del driver.
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public boolean message(String locator) {
        try {
            return Find(locator).isDisplayed();
        } catch (Exception e) {
            // Si el elemento no existe o no aparece, retorna false
            return false;
        }
    }

    /*
     * La función write permite borrar lo que hay dentro del campo de texto y
     * escribe el nuevo texto que se le entregó.
     */
    public void write(String locator, String keysToSend) {
        Find(locator).click();
        Find(locator).sendKeys(Keys.CONTROL + "a");
        Find(locator).sendKeys(Keys.DELETE);
        Find(locator).sendKeys(keysToSend);
    }

    /*
     * Funciones que buscan un elemento dentro de una lista que se despliega. Dicha
     * búsqueda es por valor, por índice y la función final entrega el tamaño de la
     * lista en cuestión.
     */
    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

}