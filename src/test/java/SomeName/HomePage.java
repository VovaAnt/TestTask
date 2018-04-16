package SomeName;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;


public class HomePage  {

    WebDriver driver;
    public HomePage(WebDriver driver ){
        this.driver = driver;
    }
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HomePage.class);


    public ResultPage search (String word)throws InterruptedException {
        logger.info("It's 'search' method here we searching our word what we get from Test: value - '"+word+"'");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        selControls page = PageFactory.initElements(driver, selControls.class);
        page.TextField.sendKeys(word);
        page.TextField.submit();
        return new ResultPage(driver);
    }

}
