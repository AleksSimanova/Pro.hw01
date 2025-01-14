import com.google.inject.Inject;
import extetions.UIExtetion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CatalogPage;
import pages.LessonCardPage;

@ExtendWith(UIExtetion.class)
public class SearchByParam_Test {

    @Inject
    private CatalogPage catalogPage;

    @Inject
    private LessonCardPage lessonCardPage;

    @Test
    public void searchByParam(){
        catalogPage
                .open();
        catalogPage.searchCourse("Фасилитация IT команд");

    }

}
