package SomeName;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


//import java.util.NoSuchElementException;
//import java.util.concurrent.TimeUnit;

public class HomePage  {

    WebDriver driver;
    public HomePage(WebDriver driver ){
        this.driver = driver;
    }


    public ResultPage search (String word)throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        selControls page = PageFactory.initElements(driver, selControls.class);
        page.TextField.sendKeys(word);
        page.TextField.submit();
        return new ResultPage(driver);
    }


}



//TextField.sendKeys("automation");
//TextField.submit();

//TextField = driver.findElement(By.xpath(".//input[@class='gsfi']"));    //id='lst-ib']
//Thread.sleep(5000);
//        WebElement TextField = driver.findElement(By.xpath(".//input[@id='lst-ib']"));