package SomeName;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    WebDriver driver;
    public ResultPage(WebDriver driver ){
        this.driver = driver;
    }
    public void  chooseLink(int i){
        driver.findElement(By.xpath("(//*[@id='rso']//a)["+i+"]")).click();
    }

    public void searchDomainThroughPages(String domain) {
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
        Assert.assertTrue("Domain NotFound!!! ", domainIsFound);
    }

}
