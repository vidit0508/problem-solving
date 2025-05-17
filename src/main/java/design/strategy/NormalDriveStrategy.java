package src.main.java.design.strategy;

public class NormalDriveStrategy implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("normal drive capability.");
    }
}
