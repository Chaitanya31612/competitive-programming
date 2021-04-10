import java.util.Arrays;
import java.util.Scanner;

public class JellyProblem {

    static class SizesGroup {
        int[] array = new int[3];
        public SizesGroup() {
//            Arrays.fill(array, Integer.MIN_VALUE);
        }
//        int a = 0;
//        int b = 0;
//        int c = 0;
    }

    public static void findMax(int n, int[] sizes, int[] ans) {

        int[] storage = new int[n + 1];
        SizesGroup group[] = new SizesGroup[n + 1];
        group[0] = new SizesGroup();
        group[0].array = new int[]{0, 0, 0};
        Arrays.fill(storage, Integer.MAX_VALUE);
        storage[0] = 0;

        for(int i = 1; i <= n; i++) {
            boolean wentInside = false;
            for(int j = 0; j < sizes.length; j++) {
                if(i - sizes[j] >= 0) {
                    wentInside = true;
                    int subAns = storage[i - sizes[j]];
                    storage[i] = Math.min(storage[i], subAns + 1);
                    group[i] = new SizesGroup();
                    SizesGroup subGroup = group[i - sizes[j]];
                    group[i].array[j] = Math.max(group[i].array[j], subGroup.array[j] + 1);
//                    ans[j]++;
//                    flag = true;
                }
            }

            if(!wentInside) {
                storage[i] = 0;
                group[i] = new SizesGroup();
                group[i].array = new int[]{0,0,0};
            }
        }

        boolean flag = false;
        for(int i = 0; i < 3; i++) {
            if(group[n].array[i] > 0) {
                flag = true;
            }
        }

        System.out.println("no " + storage[n]);
        if(flag) {
            for(int i = 0; i < 3; i++) {
                System.out.print(group[n].array[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("impossible");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sizes = new int[3];
        for(int i = 0; i < 3; i++) {
            sizes[i] = sc.nextInt();
        }

        int[] ans = new int[3];
        for(int i = 0; i < n; i++) {
            Arrays.fill(ans, 0);
            findMax(arr[i], sizes, ans);
//            boolean flag = findMax(arr[i], sizes, ans);
//            // print
//            if(flag) {
//                for(int j = 0; j < 3; j++) {
//                    System.out.print(ans[j] + " ");
//                }
//                System.out.println();
//            } else {
//                System.out.println("impossible");
//            }
        }
    }
}
