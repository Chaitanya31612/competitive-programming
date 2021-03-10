package vehicle;

public class Car extends Vehicle {
    int numGears;
    boolean isConvertable;

    // although color and maxspeed are not declared here we can access them as we have inherited them
    public void printCar() {
        super.print();
        System.out.println("numGears = " + numGears);
        System.out.println("isConvertable = " + isConvertable);
    }
}
