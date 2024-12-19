package components.static_components;


import annotations.components.Component;
import components.AbsComponent;
import data.menu.HeaderMenuData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Component("css : a[href='/' ~nav")
public class HeaderMenuComponent extends AbsComponent<HeaderMenuComponent> {
    public HeaderMenuComponent(WebDriver driver){
        super(driver);
    }

    public HeaderMenuComponent setFocusMenuItem(HeaderMenuData headerMenuData){
        String locator = String.format("//div[./span[text='%s']]",headerMenuData.getName());
        action.moveToElement($(By.xpath(locator))).build().perform();
        return this;
    }
}
