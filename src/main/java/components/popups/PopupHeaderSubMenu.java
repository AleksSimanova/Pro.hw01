package components.popups;

import annotations.components.Component;
import components.AbsComponent;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.assertThat;

@Component("internal_component : .//div[./a[contains(@href,'/categories')]]")
public class PopupHeaderSubMenu extends AbsComponent<PopupHeaderSubMenu> implements IPopup {

    public PopupHeaderSubMenu(WebDriver driver){
        super(driver);
    }

    @Override
    public PopupHeaderSubMenu popupShouldNotVisible() throws Exception {
        assertThat( waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
                .as("this element{} is visible ",getComponentBy())
                .isTrue();

        return this;
    }

    @Override
    public PopupHeaderSubMenu popupShouldVisible() throws Exception {
        assertThat( waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
                .as("this element{} is not visible ",getComponentBy())
                .isTrue();


        return this;
    }
}
