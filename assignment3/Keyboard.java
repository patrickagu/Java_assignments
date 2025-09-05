package assignment3;

public abstract class Keyboard {
    // instance variables
    protected int numberOfKeys;
    public String layout;

    // a constructor with numberOfKeys and layout
    public Keyboard(int numberOfKeys, String layout) {
        this.numberOfKeys = numberOfKeys;
        this.layout = layout;
    }

    // concrete method
    public void displayInfo() {
        System.out.println("Keyboard with " + numberOfKeys + " keys in " + layout + " layout");
    }

    // abstract method
    public abstract void type(String text);

}