public class PalindromeString {

    static int palindrome(String S) {
        int n = S.length();
        for(int i = 0; i < n/2; i++) {
            if(S.charAt(i) != S.charAt(n-i-1)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(palindrome("abcba"));
        System.out.println(palindrome("abc"));

    }
}
