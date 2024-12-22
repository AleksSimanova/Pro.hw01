import com.google.inject.Inject;
import components.popups.PopupHeaderSubMenu;
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
    private LessonCardPage lessonCardPage;

    @Inject
    private PopupHeaderSubMenu popupHeaderSubMenu;

    @Inject
    private MenuDirectionComponent menuDirectionComponent;


    @Test
    public void choosingDirection() throws Exception {
        mainPage.open().choiceRandomDirection();
        String randomDirection = popupHeaderSubMenu.randomDestination();
        popupHeaderSubMenu.clickDirection(randomDirection);
        menuDirectionComponent.selectDirection(randomDirection);

    }
}
