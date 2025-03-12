// Superclass Device
class Device {
    protected String deviceId;
    protected String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass Thermostat extending Device
class Thermostat extends Device {
    private int temperatureSetting;

    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main Class to Test Smart Home System
public class SmartHome {
    public static void main(String[] args) {
        // Creating a Thermostat object
        Thermostat smartThermostat = new Thermostat("TH123", "ON", 24);

        // Displaying device status
        smartThermostat.displayStatus();
    }
}
