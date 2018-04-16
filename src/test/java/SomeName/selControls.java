package SomeName;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class selControls {


    WebDriver driver;

    public selControls(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//input[@id='lst-ib']")
    public WebElement TextField;

    @FindBy(xpath = "//cite[@class='iUh30']")
    public List<WebElement> Domains;

    @FindBy(id = "pnnext")
    public WebElement Next;

}

