public class Vehicle implements PrintInterface {
    protected String color;
    private int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("color = " + color);
        System.out.println("maxSpeed = " + maxSpeed);
    }
}
