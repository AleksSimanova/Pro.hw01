package common;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Guice;

import modules.GuicePageModules;
import waiters.Waiters;;

public abstract class AbsCommon<T> {

    protected WebDriver driver;
    protected Actions action;
    protected Waiters waiters;

    public AbsCommon(WebDriver driver){
        this.driver = driver;
        this.action=new Actions(driver);
        this.waiters = new Waiters(driver);



        PageFactory.initElements(driver, this);
    }

    protected WebElement $(By locator){
        return driver.findElement(locator);
    }

    protected List <WebElement> $$(By locator){
        return driver.findElements(locator);
    }
}