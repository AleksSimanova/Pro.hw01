import com.google.inject.Inject;
import extetions.UIExtetion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CatalogPage;
import pages.LessonCardPage;

@ExtendWith(UIExtetion.class)
public class BeginningOfTraining_Test {

    @Inject
    private CatalogPage catalogPage;

    @Inject
    private LessonCardPage lessonCardPage;

    @Test
    public void pageNameOpen() throws Exception {
        catalogPage.open();
        catalogPage.jsoupData();
        String earlyCourse = catalogPage.getEarlyCourse();
        catalogPage.clickCourse(earlyCourse);
        lessonCardPage.namePageShouldBe(earlyCourse);
        String lateCourse = catalogPage.getLateOneCourses();
        catalogPage.open();
        catalogPage.clickCourse(lateCourse);
        lessonCardPage.namePageShouldBe(lateCourse);
    }
}
