package components.static_components;

import annotations.components.Component;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Component("internal_component : //div[div /p/text()[.='Направление']] ")
public class MenuDirectionComponent extends AbsStaticComponents {

    public MenuDirectionComponent(WebDriver driver) {
        super(driver);
    }

    String directionCoursesLocalTemplate = "//div[label/text()[. ='%s']]";


    public void selectDirection(String nameDirectionIsSelected) {
        String locator = String.format(directionCoursesLocalTemplate, nameDirectionIsSelected);
        waiters.waitForVisible($(By.xpath(locator)));
        Assertions.assertThat($(By.xpath(locator)).isSelected()).as("The direction {}is not selected", nameDirectionIsSelected);
    }
}
