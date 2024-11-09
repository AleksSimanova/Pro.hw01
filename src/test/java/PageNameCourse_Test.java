import com.google.inject.Inject;
import data.menu.CoursesData;
import extetions.UIExtetion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CatalogPage;
import pages.LessonCardPage;
import pages.MainPage;

@ExtendWith(UIExtetion.class)
public class PageNameCourse_Test {
    @Inject
    private MainPage mainPage;

    @Inject
    private CatalogPage catalogPage;
    @Inject
    LessonCardPage lessonCardPage;

    @Test
    public void pageNameOpen(){
        catalogPage
                .open();
        String name = catalogPage
                .openAllCourses()
                .clickCourse(CoursesData.POSTGESQL);
        lessonCardPage.namePageShouldBe(name);
    }


}
