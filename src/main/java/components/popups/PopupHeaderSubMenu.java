package components.popups;

import annotations.components.Component;
import com.google.inject.Inject;
import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CatalogPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@Component("internal_component : .//div[./a[contains(@href,'/categories')]]")
public class PopupHeaderSubMenu extends AbsComponent<PopupHeaderSubMenu> implements IPopup {

    @Inject
    private CatalogPage catalogPage;

    String nameDirectionLocatorTemplate = "//a/text()[. ='%s']";
    String listDirectionLocator = "//div[p /text()[.='Все курсы']]/div/a";


    public PopupHeaderSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public PopupHeaderSubMenu popupShouldNotVisible() throws Exception {
        assertThat(waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
                .as("this element{} is visible ", getComponentBy())
                .isTrue();

        return this;
    }

    @Override
    public PopupHeaderSubMenu popupShouldVisible() throws Exception {
        assertThat(waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
                .as("this element{} is not visible ", getComponentBy())
                .isTrue();


        return this;
    }

    public String randomDestination() {
        List<WebElement> direction = $$(By.xpath(listDirectionLocator));
        List<String> nameDirection = new ArrayList<>();
        for (WebElement element : direction) {
            nameDirection.add(element.getText());
        }
        Random random = new Random();
        String randomDirection = nameDirection.get(random.nextInt(nameDirection.size()));
        return randomDirection;

    }

    public CatalogPage clickDirection(String randomDirection) {
        String randomLocator = String.format(nameDirectionLocatorTemplate, randomDirection);
        action.moveToElement($(By.xpath(randomLocator))).click().build().perform();
        return catalogPage;
    }

}
