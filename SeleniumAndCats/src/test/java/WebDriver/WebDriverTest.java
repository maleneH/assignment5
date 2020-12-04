package WebDriver;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebDriverTest {

    static final Logger logger = Logger.getLogger(WebDriverTest.class);

    WebDriver firefoxDriver;
    WebDriverWait wait;

    @BeforeAll
    void setup() {
        logger.info("@BeforeAll() called");
        System.setProperty("webdriver.gecko.driver", "C:/Users/Highyard/Desktop/Code/geckodriver-v0.28.0-win64/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.navigate().to("https://sqengineer.com/practice-sites/practice-tables-selenium/");
    }

    @Test
    void printOutRows() {
        var elements = firefoxDriver.findElements(By.ByXPath.tagName("table"));
        for (WebElement el : elements) {
            System.out.println(el.getText());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void clickEachLinkInTableOne(int value) {
        logger.info("TEST - clickEachLinkInTableOne() called");
        var tableOne = firefoxDriver.findElement(By.ByXPath.id("table1"));
        logger.info("found 'table1' by XPATH");
        var elements = (tableOne.findElements(By.ByXPath.tagName("a")));
        logger.info("found '<a>' tags by XPATH");
        var beforeClick = firefoxDriver.getCurrentUrl();
        var element = elements.get(value);
        var elementText = element.getText();
        element.click();
        logger.info(String.format("Clicked hyperlink with text: %s", elementText));
        var afterClick = firefoxDriver.getCurrentUrl();

        assertNotEquals(beforeClick, afterClick);
        logger.info(String.format("Asserted that pre- and post-URL are different on element index: %s", value));
        firefoxDriver.navigate().back();
    }
}
