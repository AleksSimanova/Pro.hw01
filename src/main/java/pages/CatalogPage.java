package pages;

import annotations.Path;
import com.google.inject.Inject;
import components.popups.Cookies;
import data.menu.CoursesData;
import io.opentelemetry.sdk.metrics.data.Data;
import modules.CoursePageModules;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;


@Path("/catalog/courses")
public class CatalogPage extends AbsBasePage {
    @Inject
    private Cookies cookies;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }


    String NAME_COURSE_LOCATOR = "//section//div/text()[.='%s']/ancestor::a";
    public String nameCourse = "";
    String cartCursesLocator = "//div[./h1]/following-sibling::div/descendant::a";
    List<WebElement> courses = new ArrayList<>();

//    public  void clickTitle(){
//        waiters.waitForVisible($(By.xpath("//div[text()='Каталог']")));
//        $(By.xpath("//div[text()='Каталог']")).click();
//        cookies.cookiesClick();
//    }

    public void openAllCourses() {

        String buttonOpenAllCoursesLocator = "//button[contains(text(),'Показать еще')]";
        String scroll = "//h5";


        if ($(By.xpath(buttonOpenAllCoursesLocator)).isDisplayed()) {
            boolean b;
            do {
                waiters.waitForVisible($(By.xpath(scroll)));
                action.scrollToElement($(By.xpath(scroll))).perform();
                $(By.xpath(buttonOpenAllCoursesLocator)).click();
                try {
                    b = waiters.waitForVisible($(By.xpath(buttonOpenAllCoursesLocator)));

                } catch (Exception exception) {
                    b = false;
                }
            } while (b);
            courses = $$(By.xpath(cartCursesLocator));
            System.out.println("список курсов получен");

        }
    }

    public String clickCourse(CoursesData coursesData) throws Exception {

        openAllCourses();
        String locator = String.format(NAME_COURSE_LOCATOR, coursesData.getNameCourses());
        waiters.waitForVisible($(By.xpath(locator)));
        $(By.xpath(locator)).click();
        nameCourse = coursesData.getNameCourses();
        return nameCourse;
    }

    Map<String, LocalDate> dataMap1 = new HashMap<>();
    List<CoursePageModules> coursesList = new ArrayList<>();

    public void jsoupData() throws IOException, ParseException {
        String dataSelector = "main section >div:nth-of-type(3) >div>div:nth-of-type(1) p";
        String nameSelector = "main section h1";
        for (int i = 0; i < courses.size(); i++) {
            WebElement item = courses.get(i);
            Document doc = Jsoup.connect(item.getAttribute("href")).get();

            Elements infoCoursesData = doc.select(dataSelector);
            Elements nameCours = doc.select(nameSelector);

            String infoDataStr = infoCoursesData.text();
            String nameCoursesStr = nameCours.text();
            if (infoDataStr.contains("декабря")) {
                infoDataStr = infoDataStr + ".2024";
            }

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MMMM.yyyy");
            LocalDate date = LocalDate.parse(infoDataStr,format);
            dataMap1.put(nameCoursesStr, date);


            LocalDate tod = LocalDate.now();
            // сортировка через reduce даты
            Optional<Integer> minDate= dataMap1.values().stream().reduce(tod, date.isBefore(tod) );

        }

    }



}

