package assignment3;

public class Vehicle {
    // instance variables with different access levels
    private String color;          // private
    protected int numberOfDoors;   // protected
    public boolean isGasPowered;   // public

    // the default constructor
    public Vehicle() {
        this.color = "white";
        this.numberOfDoors = 4;
        this.isGasPowered = true;
    }

    // constructor with all parameters
    public Vehicle(String color, int numberOfDoors, boolean isGasPowered) {
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.isGasPowered = isGasPowered;
    }

    // constructor with color only
    public Vehicle(String color) {
        this.color = color;
        this.numberOfDoors = 4;
        this.isGasPowered = true; // default gas powered
    }

    // constructor with color and doors
    public Vehicle(String color, int numberOfDoors) {
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.isGasPowered = true;
    }

    // getters and setters
    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public int getNumberOfDoors() {

        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {

        this.numberOfDoors = numberOfDoors;
    }

    public boolean isGasPowered() {

        return isGasPowered;
    }

    public void setGasPowered(boolean gasPowered) {

        isGasPowered = gasPowered;
    }

    // override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehicle vehicle = (Vehicle) obj;
        return numberOfDoors == vehicle.numberOfDoors &&
                isGasPowered == vehicle.isGasPowered &&
                color.equals(vehicle.color);
    }

    // override toString method
    @Override
    public String toString() {
        return "Vehicle{" +
                "color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", isGasPowered=" + isGasPowered +
                '}';
    }

    // isEcoFriendly method
    public boolean isEcofriendly() {

        return (numberOfDoors == 2) && (!isGasPowered);
    }

}