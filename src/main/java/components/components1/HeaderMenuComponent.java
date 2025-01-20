package components.components1;

import annotations.components.Component;
import com.google.inject.Inject;
import components.AbsComponent;
import data.menu.HeaderMenuData;
import data.menu.MenuCoursesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CatalogPage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component("css : a[href='/'] ~nav")
public class HeaderMenuComponent extends AbsComponent<HeaderMenuComponent> {
    public HeaderMenuComponent(WebDriver driver) {
        super(driver);
    }

    @Inject
    CatalogPage catalogPage;

    String nameDirectionLocatorTemplate = "//a[@href='%s']";
    String listDirectionLocator = "//div[p /text()[.='Все курсы']]/div/a";
    String trainingLocator = "//div[span[@title='Обучение']]";

    public HeaderMenuComponent setFocusMenuItem(HeaderMenuData headerMenuData) {
        String locator = String.format("//div[./span[text='%s']]", headerMenuData.getName());
        action.moveToElement($(By.xpath(locator))).build().perform();
        return this;
    }
    // проверить  локатор
    public String randomDestination() {
        List<WebElement> direction = $$(By.xpath(listDirectionLocator));
        List<String> nameDirection = new ArrayList<>();
        for (WebElement element : direction) {
            String[] e = element.getText().split(" ");
            String n = e[0];
            if (!n.equals("Подписка")) {
                nameDirection.add(n);
            }
        }
        Random random = new Random();
        String nameRandomCurses = nameDirection.get(random.nextInt(nameDirection.size()));
        return nameRandomCurses;

    }

    public CatalogPage clickDirection(String randomDirection) {
        String hrefCourses = MenuCoursesData.hrefRandomCourses(randomDirection);
        String randomLocator = String.format(nameDirectionLocatorTemplate, hrefCourses);
        action.moveToElement($(By.xpath(randomLocator))).click().build().perform();
        return catalogPage;
    }
}
