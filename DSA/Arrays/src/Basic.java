public class Basic {

    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void incrementArray(int[] input) {
        input = new int[5];
        for(int i = 0; i < input.length; i++) {
            input[i]++;
        }
        print(input);
    }

    public static void main(String[] args) {
//        int[] i = new int[10];
//        System.out.println(i);
//
//        double[] d = new double[10];
//        System.out.println(d);
//
//        long[] l = new long[10];
//        System.out.println(l);

        int[] input = {1,2,3,4,5};
        incrementArray(input);
        print(input);

    }
}
