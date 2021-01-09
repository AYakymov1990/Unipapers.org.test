package Utils;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageInit {

    protected static WebDriver driver;

    public PageInit(){

        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }
}
