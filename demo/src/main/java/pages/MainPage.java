package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.inject.Inject;

import annotations.Path;

@Path("/")
public class MainPage extends AbsBasePage <MainPage> {


    public MainPage(WebDriver driver ){
        super(driver);
    }

    @Inject
    private LessonCardPage lessonCardPage;
    
    @FindBy(xpath = "//section[./h2]//a[contains(@href,'/lessons')]")
    private List <WebElement> lessonIteam;

    public String getLessonTitleByIndex(int index){
        return lessonIteam.get(--index)
        .findElement(By.xpath(".//h5"))
        .getText();
    }

    public LessonCardPage clickLessonTitleByTitle(String title){

        String lessonCardLocatorTemplate= String.format("//a[not(@class)][contains(@href,'/lessons')][.//*[test()='%s']]", title);

        $(By.xpath(lessonCardLocatorTemplate)).click();

        return lessonCardPage;
    }
}
