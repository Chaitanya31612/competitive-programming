import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MergeInterval {

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();

        if(intervals.length == 0) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] pair: intervals) {
            if(pair[0] <= end) {
                end = Math.max(end, pair[1]);
            } else {
                list.add(new int[]{start, end});
                start = pair[0];
                end = pair[1];
            }
        }

        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                intervals[i][j] = sc.nextInt();
            }
        }

        int[][] ans = merge(intervals);
        for(int[] arr : ans)
            System.out.println(Arrays.toString(arr));
    }
}
