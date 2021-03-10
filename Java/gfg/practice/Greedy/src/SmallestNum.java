

public class SmallestNum {

    static String smallestNumber(int S, int D){
        // code here
        String num = "";
        if(S == 0 && D == 1) {
            return String.valueOf(S);
        }
        if(S > D*9) {
            return "-1";
        }

        // 1 for the most significant bit
        S -= 1;

        for(int i = D-1; i > 0; i--) {
            if(S > 9) {
                num = "9" + num;
                S -= 9;
            } else {
                num = String.valueOf(S) + num;
                S = 0;
            }
        }
        num = String.valueOf(S + 1) + num;

        return num;
    }

    public static void main(String[] args) {
        int S = 9;
        int D = 2;

        System.out.println(smallestNumber(S, D));
    }
}
