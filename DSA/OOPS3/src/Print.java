public class Print {

    // print method for only classes that have print method within them
    public static <T extends PrintInterface> void printArr(T arr[]) {
        for(int i = 0; i < arr.length; i++) {
            arr[i].print();
        }
        System.out.println();
    }

    // general print function for Integer, Long etc
//    public static <T> void printArr(T arr[]) {
//        for(int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }

    public static void main(String[] args) {
        //can't use int as it is a primitive type
//        int arr[] = new int[10];
//        printArr(arr);

//        Integer a[] = new Integer[10]; // default values null
//        for(int i = 0; i < a.length; i++) {
//            a[i] = i+1;
//        }
//        printArr(a);

        Student s1[] = new Student[10];
        for(int i = 0; i < s1.length; i++) {
            s1[i] = new Student(i+1);
        }

        printArr(s1);
    }
}
