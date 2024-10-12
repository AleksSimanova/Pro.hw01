import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.google.inject.Inject;
import extetions.UIExtetion;

import pages.MainPage;

@ExtendWith(UIExtetion.class)
public class MainPage_Test {

    @Inject
    private MainPage mainPage;

    @Test
    public void mainPageTest(){
        String lessonTitle = mainPage
            .open()
            .getLessonTitleByIndex(3);
    
        mainPage.clickLessonTitleByTitle(lessonTitle)
            .pageHeaderShouldBeSameAs(lessonTitle);
    }
}
