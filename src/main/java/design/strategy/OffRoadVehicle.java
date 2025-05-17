package src.main.java.design.strategy;

public class OffRoadVehicle extends Vehicle {

    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
