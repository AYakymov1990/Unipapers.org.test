package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            Path path = FileSystems.getDefault().getPath("src/main/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", path.toString());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Parameters("browser")
    public static void crossBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {

            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }


    public static void closeBrowser() {
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
}
