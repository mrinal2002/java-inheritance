// Superclass: Vehicle
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable (For hybrid inheritance)
interface Refuelable {
    void refuel();  // Abstract method to be implemented by PetrolVehicle
}

// Subclass: ElectricVehicle (Inherits from Vehicle)
class ElectricVehicle extends Vehicle {
    private int batteryCapacity;  // in kWh

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }
}

// Subclass: PetrolVehicle (Inherits from Vehicle & Implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {
    private int fuelCapacity;  // in liters

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel capacity: " + fuelCapacity + " liters.");
    }
}

// Main class to test the Vehicle system
public class VehicleManagement {
    public static void main(String[] args) {
        // Creating objects for ElectricVehicle and PetrolVehicle
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle bmw = new PetrolVehicle("BMW M3", 280, 60);

        // Displaying information and performing actions
        tesla.displayInfo();
        tesla.charge();
        System.out.println();

        bmw.displayInfo();
        bmw.refuel();
    }
}
