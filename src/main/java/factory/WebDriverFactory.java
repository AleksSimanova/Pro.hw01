package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptions.BrowserNotFoundException;
import factory.settings.ChromeSettings;

public class WebDriverFactory {

    private String browserName =  System.getProperty("browser", "chrome");
    
    public WebDriver create (){
        switch (browserName.trim().toUpperCase()) {
            case "CHROME": 
                ChromeOptions chromeOptions = (ChromeOptions) new ChromeSettings().settings();
                return new ChromeDriver(chromeOptions);
                
            
            case "FIREFOX":  
                return new FirefoxDriver();
            
            default:
                throw new BrowserNotFoundException(browserName);
                
        }
    }
}
