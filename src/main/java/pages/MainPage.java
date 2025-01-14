package pages;

import annotations.Path;
import com.google.inject.Inject;
import components.popups.PopupHeaderSubMenu;
import components.static_components.HeaderMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Path("/")
public class MainPage extends AbsBasePage<MainPage> {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Inject
    private HeaderMenuComponent headerMenuComponent;

    @FindBy(xpath = "//section[./h2]//a[contains(@href,'/lessons')]")
    private List<WebElement> lessonIteam;

    String trainingLocator = "//div[span[@title='Обучение']]";

    public String getLessonTitleByIndex(int index) {
        return lessonIteam.get(--index)
                .findElement(By.xpath(".//h5"))
                .getText();
    }

    public void clickLessonTitleByTitle(String title) {
        String lessonCardLocatorTemplate = String.format("//a[not(@class)][contains(@href,'/lessons')][.//*[text()='%s']]", title);
        $(By.xpath(lessonCardLocatorTemplate)).click();

    }

    public HeaderMenuComponent openSubMenu() throws Exception {
        $(By.xpath(trainingLocator)).click();
        Thread.sleep(3000);
        return headerMenuComponent;
    }

}


