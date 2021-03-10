package vehicle;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.print();

        Car c1 = new Car();
        c1.color = "black";
        c1.numGears = 10;
        c1.print();
    }
}
