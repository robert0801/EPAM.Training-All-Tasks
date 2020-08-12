package ICanWin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

abstract public class AbstractClassForPastebin {
    protected WebDriver driver;
    protected final String webSite = "https://pastebin.com";
    protected final int WAIT_TIMEOUT_SECONDS = 20;

    protected AbstractClassForPastebin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().pageLoadTimeout(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
    }

}
