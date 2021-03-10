package classes_and_objects;

public class StudentUse {
    public static void main(String[] args) {
        Student s1 = new Student("Chaitanya", 12);
        Student s2 = new Student("Someone", 34);

        System.out.println(s1.getNumStudents());
        System.out.println(Student.getNumStudents());
    }
}
