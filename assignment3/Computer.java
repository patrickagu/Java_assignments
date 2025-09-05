package assignment3;

public class Computer extends Keyboard implements Button {
    // instance variable/field
    private String brand;

    // constructor
    public Computer(int numberOfKeys, String layout, String brand) {
        super(numberOfKeys, layout); // calls the keyboard constructor
        this.brand = brand;
    }

    // to implement Button interface methods
    @Override
    public void click() {

        System.out.println("Computer button clicked");
    }

    @Override
    public boolean isPressed() {

        return false;
    }

    // implement abstract method from Keyboard
    @Override
    public void type(String text) {

        System.out.println("Typing: " + text);
    }

    // additional method for Computer
    public void powerOn() {

        System.out.println(brand + " computer is powering on");
    }

}