package pages;

import static org.assertj.core.api.Assertions.assertThat;

import annotations.PathTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PathTemplate("/ lessons/$1")
public class LessonCardPage extends AbsBasePage {
    public LessonCardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "section  h1")
    WebElement namePage;

    public boolean namePageShouldBe(String expectedName) {
        String actualNamePage = namePage.getText();
        assertThat(actualNamePage).as("Name page is not {}").isEqualTo(expectedName);
        return true;
    }

}
