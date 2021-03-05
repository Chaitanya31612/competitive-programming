import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobSequencing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}


class Solution{
    // return an array of size 2 having the 0th element equal to the count
    // and 1st element equal to the maximum profit
    int[] JobScheduling(Job arr[], int n){

        int t = Integer.MIN_VALUE;
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].deadline > t) {
                t = arr[i].deadline;
            }
        }

        boolean[] result = new boolean[t];
        Arrays.fill(result, false);
        int profit = 0, count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = Math.min(t-1, arr[i].deadline-1); j >= 0; j--) {
                if(result[j] == false) {
                    result[j] = true;
                    profit += arr[i].profit;
                    count++;
                    break;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = profit;
        return ans;
    }
}
