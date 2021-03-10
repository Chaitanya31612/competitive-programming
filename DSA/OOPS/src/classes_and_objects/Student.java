package classes_and_objects;

public class Student {
    String name = "person";
    private int rollNumber = 123;
    private static int numStudents;

    // static is used as the numstudents will be of the class and hence same for all objects
    public static int getNumStudents() {
        return numStudents;
    }

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        numStudents++;
    }

    public void setRollNumber(int rn) {
        if(rn <= 0)
            return;

        rollNumber = rn;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
