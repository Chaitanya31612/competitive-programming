public class NumberofDigits {

    public static int count(int n) {
        if(n == 1){
            return 1;
        }

        return count(n/10) + 1;
    }

    public static void main(String[] args) {
        System.out.println(count(1234));
    }
}
