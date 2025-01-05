import com.google.inject.Inject;
import components.popups.PopupHeaderSubMenu;
import components.static_components.HeaderMenuComponent;
import components.static_components.MenuDirectionComponent;
import extetions.UIExtetion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.LessonCardPage;
import pages.MainPage;

@ExtendWith(UIExtetion.class)
public class RandomDirection_Test {
    @Inject
    private MainPage mainPage;

    @Inject
    private MenuDirectionComponent menuDirectionComponent;

    @Inject
    private HeaderMenuComponent headerMenuComponent;

    @Test
    public void choosingDirection() throws Exception {
        mainPage.open();
        mainPage.openSubMenu();
        String titleD = headerMenuComponent.randomDestination();
        headerMenuComponent.clickDirection(titleD);
        menuDirectionComponent.nameCourses(titleD);
    }
}
