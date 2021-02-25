import java.util.*;

class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int m = sc.nextInt();
            int h = sc.nextInt();
    
            int bmi = (int) (m / (h * h));
    
            int ans = 0;
            if (bmi <= 18) {
                ans = 1;
            } else if (bmi >= 19 && bmi <= 24) {
                ans = 2;
            } else if (bmi >= 25 && bmi <= 29) {
                ans = 3;
            } else if (bmi >= 30) {
                ans = 4;
            }
    
            System.out.println(ans);
            
        }
    }
}