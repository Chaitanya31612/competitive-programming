import java.util.Scanner;

public class MinStepsTo1 {

    /*=================== DONT USE ============================= */
    /* not always optimal
    * eg for 10, optimal ans is 3 i.e -> 10->9->3->1
    * but our code gives 4 */
    int minStepsTo1(int n) {
        if(n == 1) {
            return 0;
        }

        int option1 = 0, option2 = 0, option3 = 0;
        if(n % 3 == 0) {
            option1 = minStepsTo1(n / 3) + 1;
        }
        else if(n % 2 == 0) {
            option2 = minStepsTo1(n / 2) + 1;
        }
        else {
            option3 = minStepsTo1(n - 1) + 1;
        }

        return Math.max(option1, Math.max(option2, option3));
    }
    /*==============================================================*/




    public static int minSteps(int n) {
        if(n == 1) {
            return 0;
        }

        // we have to compare answer from all three ways
        int op1 = minSteps(n - 1);
        int minSteps = op1;

        if(n % 3 == 0) {
            int op2 = minSteps(n / 3);
            if(op2 < minSteps) {
                minSteps = op2;
            }
        }

        if(n % 2 == 0) {
            int op3 = minSteps(n / 2);
            if(op3 < minSteps) {
                minSteps = op3;
            }
        }

        return minSteps + 1;
    }



    /* min steps using memoization */
    public static int minStepsM(int n) {
        int[] storage = new int[n + 1];
        return minStepsM(n, storage);
    }

    /* better code */
    public static int minStepsM(int n, int[] storage) {
        if(n == 1) {
            return 0;
        }

        if(storage[n] != 0) {
            return storage[n];
        }

        int op1 = minStepsM(n - 1, storage);
        int minSteps = op1;

        if(n % 3 == 0) {
            int op2 = minStepsM(n / 3, storage);
            if(op2 < minSteps) {
                minSteps = op2;
            }
        }

        if(n % 2 == 0) {
            int op3 = minStepsM(n / 2, storage);
            if(op3 < minSteps) {
                minSteps = op3;
            }
        }

        storage[n] = minSteps + 1;
        return storage[n];
    }

    /* not so good code */
    public static int minStepsMNaive(int n, int[] storage) {
        if(n == 1) {
            return 0;
        }

        int op1;
        if(storage[n-1] != 0) {
            op1 = storage[n-1];
        } else {
            op1 = minSteps(n - 1);
            storage[n - 1] = op1;
        }
        int minSteps = op1;

        if(n % 3 == 0) {
            int op2;
            if(storage[n / 3] != 0) {
                op2 = storage[n / 3];
            } else {
                op2 = minSteps(n / 3);
                storage[n / 3] = op2;
            }
            if(op2 < minSteps) {
                minSteps = op2;
            }
        }

        if(n % 2 == 0) {
            int op3;
            if(storage[n / 2] != 0) {
                op3 = storage[n / 2];
            } else {
                op3 = minSteps(n / 2);
                storage[n / 2] = op3;
            }
            if(op3 < minSteps) {
                minSteps = op3;
            }
        }

        storage[n] = minSteps + 1;
        return storage[n];
    }


    /* DP Approach - bottom up */
    public static int minStepsDP(int n) {
        int[] storage = new int[n + 1];
        // base case - shown explicitly that for 1 ans is 0
        storage[1] = 0;

        for(int i = 2; i <= n; i++) {
            int minSteps = storage[i - 1];

            if(i % 3 == 0) {
                if(storage[i / 3] < minSteps) {
                    minSteps = storage[i / 3];
                }
            }
            if(i % 2 == 0) {
                if(storage[i / 2] < minSteps) {
                    minSteps = storage[i / 2];
                }
            }
            storage[i] = 1 + minSteps;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /* DP */
        long start = System.currentTimeMillis();
        System.out.println(minStepsDP(n));
        long end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        /* Memoization */
        start = System.currentTimeMillis();
        System.out.println(minStepsM(n));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(minSteps(n));
        end = System.currentTimeMillis();
        System.out.println("It takes " +
                (end - start) + "ms");
    }
}
