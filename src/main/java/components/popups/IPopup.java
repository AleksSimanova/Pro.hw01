package components.popups;

public interface IPopup <T> {
    T popupShouldNotVisible() throws Exception;
    T popupShouldVisible() throws Exception;
}
