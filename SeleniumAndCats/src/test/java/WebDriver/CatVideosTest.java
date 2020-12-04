package WebDriver;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatVideosTest {

    static final Logger logger = Logger.getLogger(CatVideosTest.class);

    WebDriver chromeDriver;
    WebDriverWait wait;
    ChromeOptions options;

    @BeforeAll
    void setup() {
        logger.info("@BeforeAll() called");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Highyard/Desktop/Code/chromedriver_win32/chromedriver.exe");
        options = new ChromeOptions();
        options.setHeadless(true);
        chromeDriver = new ChromeDriver(options);
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5).toSeconds());
        chromeDriver.navigate().to("https://www.dailymotion.com/us");
    }

    @Test
    void mustLog10YoutubeCatVideosUploadedToday() throws InterruptedException {
        Thread.sleep(3000);
        var searchButton = chromeDriver.findElement(By.ByXPath.className("ResponsiveHeaderTab__tab___2Um0g"));
        searchButton.click();

        var searchField = chromeDriver.findElement(By.ByXPath.id("search"));
        searchField.sendKeys("cats");
        searchField.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        var radioButtons = chromeDriver.findElements(By.ByXPath.className("RadioButton__inputButtonLabel___3oA7Q"));

        Thread.sleep(1000);

        for (WebElement button : radioButtons) {
            System.out.println(button.getText());
            if (button.getText().contains("Today")){
                button.click();
                break;
            }
        }
        Thread.sleep(1000);

        var catVideos = chromeDriver.findElements(By.ByXPath.className("VideoSearchCard__videoImageWrapper___zPMT9"));

        List<String> links = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            var link = catVideos.get(i).findElement(By.ByXPath.tagName("a"));
            links.add(link.getAttribute("href"));
        }

        for (String link: links) {
            logger.info(String.format("Link added with URL: %s", link));
        }
    }
}
