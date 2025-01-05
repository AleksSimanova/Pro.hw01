package pages;

import annotations.PathTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

@PathTemplate("/ lessons/$1")
public class LessonCardPage extends AbsBasePage {
    public LessonCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "section  h1")
    WebElement namePage;

    String BREAD_CRUMBS_LOCATOR = "//section //a/text()[.='%s']";

    public boolean namePageShouldBe(String expectedName) {
        String actualNamePage = namePage.getText();
        String locator = String.format(BREAD_CRUMBS_LOCATOR, expectedName);
        assertThat(actualNamePage).as("Name page is not {}").isEqualTo(expectedName);
        assertThat(waiters.waitForVisible($(By.xpath(locator)))).as("Bread crumbs with title {} is no").isTrue();
        return true;
    }
}
