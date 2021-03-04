public class PrintSubsequenceString {

    static void printSubsequence(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        // don't include first character
        printSubsequence(input.substring(1), output);
        // include first character
        printSubsequence(input.substring(1), output+input.charAt(0));
    }

    public static void main(String[] args) {
        printSubsequence("abc", "");
    }
}
