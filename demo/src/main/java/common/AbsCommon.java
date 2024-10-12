package common;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Guice;

import modules.GuicePageModules;;

public abstract class AbsCommon<T> {

    protected WebDriver driver;
    protected Actions action;

    public AbsCommon(WebDriver driver){
        this.driver = driver;
        this.action=new Actions(driver);

        Guice.createInjector(new GuicePageModules()).injectMembers(this);

        PageFactory.initElements(driver, this);
    }

    protected WebElement $(By locator){
        return driver.findElement(locator);
    }

    protected List <WebElement> $$(By locator){
        return driver.findElements(locator);
    }
}
