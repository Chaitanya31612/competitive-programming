package vehicle_temp;

import vehicle.Vehicle;

public class Truck extends Vehicle {
    int maxCapacity;

    public void print() {
        System.out.println("maxCapacity = " + maxCapacity);
        System.out.println("color = " + color);
    }
}
