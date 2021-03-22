package cookoffmarch;

import java.util.Scanner;

public class GuessIt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            double l = 1;
            double r = Math.pow(10,6);
            int number = (int) Math.ceil(Math.sqrt(l));
            int n2 = number * number;
            number = (number * 2) + 1;
            while ((n2 >= l && n2 <= r)){
                System.out.println(n2);
                System.out.flush();
                int a = sc.nextInt();
                if(a==1)
                    break;
                else if(a==-1)
                    System.exit(0);
                n2 = n2 + number;
                number += 2;
            }


        }
    }
}
