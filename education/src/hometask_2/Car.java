package hometask_2;

public class Car {

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startFuelSystem() {
        System.out.println("Fuel system started");
    }

    private void startCommand() {
        System.out.println("Command system started");
    }

    private void startElectricity() {
        System.out.println("Electricity started");
    }
}
