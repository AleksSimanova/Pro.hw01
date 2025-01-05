package components.popups;

import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

//@Component("internal_component : //span/text()[.='Посещая наш сайт, вы принимаете']/following::div/button")
public class Cookies extends AbsComponent<Cookies> {
    public Cookies(WebDriver driver) {
        super(driver);
    }
    // protected String cookiesButtonLocator = "//span/text()[.='Посещая наш сайт, вы принимаете']/following::div/button";
//
//    @Override
//    public Cookies popupShouldVisible() throws Exception {
//        assertThat( waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
//                .as("this element{} is not visible ",getComponentBy())
//                .isTrue();
//        System.out.println(        assertThat( waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
//                .as("this element{} is not visible ",getComponentBy())
//                .isTrue());
//        return this;
//    }
//
//    @Override
//    public Cookies popupShouldNotVisible() throws Exception {
//        assertThat( waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
//                .as("this element{} is visible ",getComponentBy())
//                .isTrue();
//        assertThat( waiters.waitForInvisible(getComponentEntity().findElement(getComponentBy())))
//                .as("this element{} is visible ",getComponentBy())
//                .isTrue());
//
//        return this;
//    }

    public void cookiesClick() {
        String cookiesButtonLocator = "//div[text()='OK']/parent::button";
        waiters.implicitly();
        assertThat(waiters.waitForCondition(ExpectedConditions.elementToBeClickable($(By.xpath(cookiesButtonLocator))))).as("cookies are not offered").isTrue();
        WebElement button = $(By.xpath(cookiesButtonLocator));
        action.clickAndHold(button).perform();
        assertThat(waiters.waitForInvisible($(By.xpath(cookiesButtonLocator)))).as("cookies are not accepted").isTrue();
    }

}
