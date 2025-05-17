package src.main.java.design.strategy;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
