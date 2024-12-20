package pages;

import annotations.Path;
import com.google.inject.Inject;
import components.popups.Cookies;
import data.menu.CoursesData;
import modules.CoursePageModules;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


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
    List<WebElement> listCoursesElemaints = new ArrayList<>();


//    public  void clickTitle(){
//        waiters.waitForVisible($(By.xpath("//div[text()='Каталог']")));
//        $(By.xpath("//div[text()='Каталог']")).click();
//        cookies.cookiesClick();
//    }

    public CatalogPage listCourses() {

        listCoursesElemaints = $$(By.xpath(cartCursesLocator));
        return this;
    }


//    public CatalogPage openAllCourses() {
//
//        String buttonOpenAllCoursesLocator = "//button[contains(text(),'Показать еще')]";
//        String scroll = "//h5";
//
//        if ($(By.xpath(buttonOpenAllCoursesLocator)).isDisplayed()) {
//            boolean b;
//            do {
//                waiters.waitForVisible($(By.xpath(scroll)));
//                action.scrollToElement($(By.xpath(scroll))).perform();
//                $(By.xpath(buttonOpenAllCoursesLocator)).click();
//                try {
//                    b = waiters.waitForVisible($(By.xpath(buttonOpenAllCoursesLocator)));
//
//                } catch (Exception exception) {
//                    b = false;
//                }
//            } while (b);
//            courses = $$(By.xpath(cartCursesLocator));
//            System.out.println("список курсов получен");
//        }
//        return this;
//    }

//    public String clickCourse(CoursesData coursesData) throws Exception {
//
//        openAllCourses();
//        String locator = String.format(NAME_COURSE_LOCATOR, coursesData.getNameCourses());
//        waiters.waitForVisible($(By.xpath(locator)));
//        $(By.xpath(locator)).click();
//        nameCourse = coursesData.getNameCourses();
//        return nameCourse;
//    }

    Map<String, LocalDate> dateMap1 = new HashMap<>();
    List<CoursePageModules> coursesList = new ArrayList<>();

    public void jsoupData() throws IOException, ParseException {
        String dataSelector = "main section >div:nth-of-type(3) >div>div:nth-of-type(1) p";
        String nameSelector = "main section h1";

        for (WebElement element :listCoursesElemaints) {
            LocalDate date;
            Document doc = Jsoup.connect(element.getAttribute("href")).get();

            Elements infoCoursesData = doc.select(dataSelector);
            Elements nameCours = doc.select(nameSelector);

            String infoDataStr = infoCoursesData.text();
            String nameCoursesStr = nameCours.text();
            if(infoDataStr.contains("Сообщить о старте наборв")){
                infoDataStr = "31.января.2050";
            }
            if (infoDataStr.contains("декабря")) {
                infoDataStr = infoDataStr + " 2024";
                DateTimeFormatter format = DateTimeFormatter.ofPattern("d.MMMM.yyyy",Locale.forLanguageTag("ru-RU"));
                date = LocalDate.parse(infoDataStr, format);

            }else{DateTimeFormatter format = DateTimeFormatter.ofPattern("d.MMMM.yyyy", Locale.forLanguageTag("ru-RU"));
                 date = LocalDate.parse(infoDataStr, format);
               }


            dateMap1.put(nameCoursesStr, date);

            dateMap1.forEach((key, value) -> System.out.println(key + "" + value));

            ChronoLocalDate d1 = null;
            LocalDate minDate = dateMap1.values().stream().reduce(LocalDate.MAX, (early, late) -> early.isAfter(late) ? late : early);
            LocalDate maxDate = dateMap1.values().stream().reduce(LocalDate.MIN, (early, late) -> early.isBefore(late) ? late : early);
            System.out.println("minDate = " + minDate + " maxDate = " + maxDate);
            Map<String, LocalDate> sortCour = dateMap1.entrySet().stream()
                    .sorted((cours1, cousr2) ->
                            !cours1.getValue().equals(cousr2.getValue()) ? -cours1.getValue().compareTo(cousr2.getValue()) :
                                    cours1.getKey().compareTo(cousr2.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, HashMap::new));

        }

    }

}





