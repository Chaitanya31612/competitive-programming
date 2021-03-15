public class Student implements PrintInterface{
    int rollNumber;

    public Student(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void print() {
        System.out.println(rollNumber);
    }
}
