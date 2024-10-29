package modules;

import org.openqa.selenium.WebDriver;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import factory.WebDriverFactory;
import pages.LessonCardPage;
import pages.MainPage;


public class GuicePageModules  extends AbstractModule{

private WebDriver driver = new WebDriverFactory().create();

    @Provides
    private WebDriver getDriver() {
        return driver;
    } 

    @Singleton
    @Provides
    public MainPage getMainPage(){
        return new MainPage(driver);
        
    }

    @Singleton
    @Provides
    public LessonCardPage getLessonCardPage(){
        return new LessonCardPage(driver);
    }
}
