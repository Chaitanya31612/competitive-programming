public class ReverseString {
    static void reverseString(char[] s) {
        if(s.length == 0)
            return;

        for(int i = 0; i < s.length/2; i++) {
            if(i != s.length - i - 1) {
                char temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] s = "abcde".toCharArray();
        reverseString(s);
        System.out.println(s);
    }
}
