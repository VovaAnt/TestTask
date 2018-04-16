package SomeName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Tests {

    String searchWord = "Automation";
    String searchDomain = "https://www.testautomationday.com/";

    private WebDriver driver;

    @Before
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\\\1_EPAM_TestTask\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com/xhtml");
    }

    @After
    public void CloseDriver() {
        driver.close();
    }

    @Test
    public void ChromeTest_1 () throws InterruptedException {
        HomePage mainPage = new HomePage(driver);
        ResultPage pageWithLinks = mainPage.search(searchWord);
        pageWithLinks.chooseLink(1);
        Assert.assertTrue(driver.getTitle().contains("Automation"));
    }

    @Test
    public void ChromeTest_2 () throws InterruptedException {
        HomePage mainPage = new HomePage(driver);
        ResultPage pageWithLinks = mainPage.search(searchWord);
        pageWithLinks.searchDomainThroughPages(searchDomain);
    }

}

