package SomeName;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ResultPage.class);
    WebDriver driver;
    public ResultPage(WebDriver driver ){
        this.driver = driver;
    }
    public void  chooseLink(int i){
        driver.findElement(By.xpath("(//*[@id='rso']//a)["+i+"]")).click();
    }

    public void searchDomainThroughPages(String domain) {
        logger.info("It's 'searchDomainThroughPages' method here we searching our Domain, what we get from Test: value - '"+domain+"', on first 5 pages");
        boolean domainIsFound = false;
        selControls page = PageFactory.initElements(driver, selControls.class);
        for (int i = 0; i<=5; i++){
            List<WebElement> ff = page.Domains.stream().filter(a -> a.getText().contains(domain)).collect(Collectors.toList());
            if (ff.size()>0) {
                domainIsFound = true;
                break;
            }
                else{page.Next.click();
            }
        }
        try{
            Assert.assertTrue("Domain NotFound!!! On pages 1-5! ", domainIsFound);
        }catch (Exception e){
            e.getLocalizedMessage();
            logger.error(e);
        }
    }

}
