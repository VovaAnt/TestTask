package SomeName;

import Parameters.ConfigProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class Tests  {

    String browser =  ConfigProperties.getTestProperty("browser");
    String searchWord  = ConfigProperties.getTestProperty("searchWord");// = "Automation";
    String searchDomain =  ConfigProperties.getTestProperty("searchDomain");
    private WebDriver driver;
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Tests.class);

    @Before
    public void setDriver() {
        logger.info("Here we set up the driver for: '"+browser+"'");
        switch (browser) {
            case "FirefoxDriver":
                System.setProperty("webdriver.geckodriver.driver", ".\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void CloseDriver() {
        driver.close();
    }

    @Test
    public void Test_1 () throws InterruptedException {
        logger.info("Start first test: 'In this test we get 'Word' from 'ConfigProperties.properties' file, which we wil serf in Google. 'in our variable right now - "+ searchWord);
        driver.get("http://www.google.com/xhtml");
        HomePage mainPage = new HomePage(driver);
        ResultPage pageWithLinks = mainPage.search(searchWord);
        pageWithLinks.chooseLink(1);
        Assert.assertTrue(driver.getTitle().contains("Automation"));
    }

    @Test
    public void Test_2 () throws InterruptedException {
        logger.info("Start second test: 'In this test we get 'Domain' from 'ConfigProperties.properties' file, which we wil check on existing in 1-5 pages in Google. '/n in our variable right now - "+ searchDomain);
        driver.get("http://www.google.com/xhtml");
        HomePage mainPage = new HomePage(driver);
        ResultPage pageWithLinks = mainPage.search(searchWord);
        pageWithLinks.searchDomainThroughPages(searchDomain);
    }
}
