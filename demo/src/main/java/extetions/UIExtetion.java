package extetions;


import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import com.google.inject.Guice;
import com.google.inject.Inject;

import modules.GuicePageModules;

public class UIExtetion implements BeforeAllCallback, AfterAllCallback {

    @Inject
    private WebDriver driver;

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Guice.createInjector(new GuicePageModules()).injectMembers(context.getTestInstance().get());
    }
}
