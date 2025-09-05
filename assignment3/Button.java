package assignment3;

public interface Button {
    // two constant values
    String BUTTON_TYPE = "Push Button";
    int MAX_CLICKS = 150;

    // the two methods
    void click();
    boolean isPressed();
}