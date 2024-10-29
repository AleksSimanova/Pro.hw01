package pages;

import org.openqa.selenium.WebDriver;

import annotations.PathTemplate;


@PathTemplate("/ lessons/$1")
public class LessonCardPage extends AbsBasePage {
    public LessonCardPage (WebDriver driver){
        super(driver);
    }
    

}
