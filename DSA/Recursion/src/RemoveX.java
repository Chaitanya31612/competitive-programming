public class RemoveX {

    public static String removeX(String str, char x) {
        if(str.length() == 1) {
            return "";
        }

        String ans = "";
        if(str.charAt(0) != x) {
            ans = ans + str.charAt(0);
        }

        return ans + removeX(str.substring(1), x);
    }

    public static void main(String[] args) {
        String str = "xaxbxadabxb";
        System.out.println(removeX(str, 'x'));
    }
}
