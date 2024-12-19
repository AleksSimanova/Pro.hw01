package components.popups;


import annotations.components.Component;
import components.AbsComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;


public class PopupStickyBanner extends AbsComponent<PopupStickyBanner> {

    public PopupStickyBanner(WebDriver driver) {
        super(driver);
    }
    String bannerSelector = "div.sticky-banner";

//    @Override
//    public PopupStickyBanner popupShouldNotVisible() throws Exception {
//        assertThat(waiters.waitForInvisible($(By.cssSelector(bannerSelector))))
//                .as("element visible {}",bannerSelector)
//                .isTrue();
//
//        return this;
//    }

//    @Override
//    public PopupStickyBanner popupShouldVisible() throws Exception {
//        assertThat(waiters.waitForVisible($(By.cssSelector(bannerSelector))))
//                .as("element not visible {}",bannerSelector)
//                .isTrue();
//
//
//        return this;
//    }
    String removeButtonSelector = "div.sticky-banner__close";
    public void removeAdvertisingPoster() throws Exception {

        assertThat(waiters.waitForCondition(ExpectedConditions.elementToBeClickable($(By.cssSelector(removeButtonSelector))))).as("banner are not offered").isTrue();
        $(By.cssSelector(removeButtonSelector)).click();
        assertThat(waiters.waitForInvisible($(By.cssSelector(removeButtonSelector)))).as("banner are not accepted").isTrue();

//        popupShouldVisible();
//        $(By.cssSelector(removeButtonSelector)).click();
//        popupShouldNotVisible();
    }
}
