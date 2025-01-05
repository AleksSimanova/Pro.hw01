import com.google.inject.Inject;
import components.popups.Cookies;
import extetions.UIExtetion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CatalogPage;
import pages.LessonCardPage;

@ExtendWith(UIExtetion.class)
public class BeginningOfTraining_Test {
//    @Inject
//    private MainPage mainPage;

    @Inject
    private CatalogPage catalogPage;
    @Inject
    private LessonCardPage lessonCardPage;
    @Inject
    private Cookies cookies;

    @Test
    public void pageNameOpen() throws Exception {
        catalogPage
                .open();
//        popupStickyBanner.removeAdvertisingPoster();
//        catalogPage.openAllCourses();
        catalogPage.listCourses().jsoupData();
//        popupStickyBanner.removeAdvertisingPoster();
//        cookies.cookiesClick();
//
//
//
//        String name = catalogPage
//                .clickCourse(CoursesData.POSTGESQL);
//        lessonCardPage.namePageShouldBe(name);
    }

}
