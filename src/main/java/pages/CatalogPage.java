package pages;

import annotations.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Path("/catalog/courses")
public class CatalogPage extends AbsBasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    String NameCoursesLocatorTemp = "//section//div/text()[.='%s']/ancestor::a";
    String cartCursesLocator = "//div[./h1]/following-sibling::div/descendant::a";
    String lateOneCourses;
    String earlyOneCourses;
    Map<String, String> dateMapString = new HashMap<>();
    Map<String, LocalDate> newMapFormatDate;
    List earlyCourses = new ArrayList();
    List lateCourses = new ArrayList();

    public void clickCourse(String nameCoursePageCatalog) throws Exception {
        String locator = String.format(NameCoursesLocatorTemp, nameCoursePageCatalog);
        waiters.waitForVisible($(By.xpath(locator)));
        $(By.xpath(locator)).click();
    }

    public void jsoupData() throws IOException, ParseException {
        List<WebElement> listCoursesElements = $$(By.xpath(cartCursesLocator));
        String dataSelector = "main section >div:nth-of-type(3) >div>div:nth-of-type(1) p";
        String nameSelector = "main section h1";
        for (WebElement element : listCoursesElements) {
            Document doc = Jsoup.connect(element.getAttribute("href")).get();
            Elements infoCoursesData = doc.select(dataSelector);
            Elements nameCours = doc.select(nameSelector);
            String infoDataStr = infoCoursesData.text();
            String nameCoursesStr = nameCours.text();
            if (infoDataStr.contains("Сообщить о старте набора")) {
                infoDataStr = "31.января.2050";
            }
            if (infoDataStr.contains("декабря 2024")) {
                infoDataStr = infoDataStr;
            } else {
                infoDataStr = infoDataStr + " 2025";
            }
            dateMapString.put(nameCoursesStr, infoDataStr);
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.forLanguageTag("ru-RU"));
        newMapFormatDate = dateMapString.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        LocalDate.parse(entry.getValue(), format)));
    }

    public String getEarlyCourse() {
        LocalDate minDate = newMapFormatDate.values().stream().reduce(LocalDate.MAX, (early, late) -> early.isAfter(late) ? late : early);
        for (Map.Entry<String, LocalDate> entry : newMapFormatDate.entrySet()) {
            if (minDate.equals(entry.getValue())) {
                earlyCourses.add(entry.getKey());
            }
        }
        earlyOneCourses = arrayRandom(earlyCourses);
        System.out.println(earlyOneCourses);
        return earlyOneCourses;

    }

    public String getLateOneCourses() {
        LocalDate maxDate = newMapFormatDate.values().stream().reduce(LocalDate.MIN, (early, late) -> early.isBefore(late) ? late : early);
        for (
                Map.Entry<String, LocalDate> entry : newMapFormatDate.entrySet()) {
            if (maxDate.equals(entry.getValue())) {
                lateCourses.add(entry.getKey());
            }
        }
        return lateOneCourses = arrayRandom(lateCourses);
    }

    public String arrayRandom(List list) {
        Random r = new Random();
        String oneMeaning = (String) list.get(r.nextInt(list.size()));
        return oneMeaning;
    }

    public void searchCourse(String name) {
        String locator = String.format(cartCursesLocator + "/h6");
        List<WebElement> coursesList = $$(By.xpath(locator));
        coursesList.stream()
                .filter(e -> e.getText().equals(name))
                .findFirst()
                .ifPresent(el -> el.click());

    }

}









