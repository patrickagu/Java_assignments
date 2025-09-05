package assignment3;

public class Truck extends Vehicle {
    // additional instance variables
    public int seats;          // public
    protected double trunkSpace;  // protected

    // the default constructor
    public Truck() {
        super(); // this calls the Vehicle's default constructor
        this.seats = 2;       // default
        this.trunkSpace = 10.5;   // default
    }

    // constructor with Vehicle variables only
    public Truck(String color, int numberOfDoors, boolean isGasPowered) {
        super(color, numberOfDoors, isGasPowered);
        this.seats = 2;
        this.trunkSpace = 10.5;
    }

    // constructor with color only
    public Truck(String color) {
        super(color);
        this.seats = 2;
        this.trunkSpace = 10.5;
    }

    // constructor with color and numberOfDoors
    public Truck(String color, int numberOfDoors) {
        super(color, numberOfDoors);
        this.seats = 2;
        this.trunkSpace = 10.5;
    }

    // constructor with Vehicle variables and seats
    public Truck(String color, int numberOfDoors, boolean isGasPowered, int seats) {
        super(color, numberOfDoors, isGasPowered);
        this.seats = seats;
        this.trunkSpace = 10.5; // default trunk space
    }

    // constructor with Vehicle variables and trunkSpace
    public Truck(String color, int numberOfDoors, boolean isGasPowered, double trunkSpace) {
        super(color, numberOfDoors, isGasPowered);
        this.seats = 2;
        this.trunkSpace = trunkSpace;
    }

    // constructor with all the parameters
    public Truck(String color, int numberOfDoors, boolean isGasPowered, int seats, double trunkSpace) {
        super(color, numberOfDoors, isGasPowered);
        this.seats = seats;
        this.trunkSpace = trunkSpace;
    }

    // constructor with seats and trunkSpace only
    public Truck(int seats, double trunkSpace) {
        super(); // this calls Vehicle's default constructor
        this.seats = seats;
        this.trunkSpace = trunkSpace;
    }

    // override equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        Truck truck = (Truck) obj;
        return seats == truck.seats &&
                Double.compare(truck.trunkSpace, trunkSpace) == 0;
    }

    // override toString method
    @Override
    public String toString() {
        return "Truck{" +
                "color='" + getColor() + '\'' +
                ", numberOfDoors=" + getNumberOfDoors() +
                ", isGasPowered=" + isGasPowered() +
                ", seats=" + seats +
                ", trunkSpace=" + trunkSpace +
                '}';
    }

    // override isEcofriendly method
    @Override
    public boolean isEcofriendly() {

        return super.isEcofriendly() && (seats <= 2) && (trunkSpace == 0);
    }

}