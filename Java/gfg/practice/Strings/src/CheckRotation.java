public class CheckRotation {

    static boolean checkRotation(String str1, String str2) {

        return ((str1.length() == str2.length()) && (str1 + str2).indexOf(str2) != -1);
    }

    public static void main(String[] args) {
        String str1 = "AACD";
        String str2 = "ACDA";

        if(checkRotation(str1, str2))
            System.out.println("rotations");
        else
            System.out.println("rotations");
    }
}
