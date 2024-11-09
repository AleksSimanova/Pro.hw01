package pages;

import annotations.PathTemplate;
import data.menu.CoursesData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.SplittableRandom;


@PathTemplate("/catalog/courses")
public class CatalogPage extends AbsBasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }
    String NAME_COURSE_LOCATOR = "//section//div/text()[.='%s']/ancestor::a";
    public String nameCourse ="";

    public CatalogPage openAllCourses(){
        String buttonOpenAllCoursesLocator = "//button[contains(text(),'Показать еще')]";
        while (waiters.waitForVisible($(By.xpath(buttonOpenAllCoursesLocator)))){
            $(By.xpath(buttonOpenAllCoursesLocator)).click();
        }
        return this;
    }

    public String  clickCourse(CoursesData coursesData){
        String locator = String.format(NAME_COURSE_LOCATOR,coursesData.getNameCourses());
        waiters.waitForVisible($(By.xpath(locator)));
        $(By.xpath(locator)).click();
        nameCourse =coursesData.getNameCourses();
        return nameCourse;
    }
}
