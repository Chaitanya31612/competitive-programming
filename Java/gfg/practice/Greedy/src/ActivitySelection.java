import java.util.Arrays;
import java.util.Comparator;

class Activity {
    int start, end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {

    public static void sortEnd(Activity arr[]) {
        Arrays.sort(arr, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.end - o2.end;
            }
        });
    }

    public static int countActivity(Activity arr[], int n) {
        sortEnd(arr);

        int i = 0, count = 1;


        for(int j = 1; j < n; j++) {
            if(arr[j].start > arr[i].end) {
                count++;
                i = j;
            }
        }

        return count;
    }

    public static int maxMeetings(int start[], int end[], int n) {
        Activity arr[] = new Activity[n];

        for(int i = 0; i < n; i++) {
            arr[i] = new Activity(start[i], end[i]);
        }

        return countActivity(arr, n);
    }

    public static void main(String[] args) {
        int[] start = {86, 32, 31 ,98, 37 ,65 ,98, 71 ,99 ,58 ,59, 32 ,52 ,69,15, 75, 4,86 ,57,36, 83, 18,58 ,50 ,43, 29 ,98,53, 80 ,5 ,89 ,73 ,8 ,97, 17 ,100 ,9 ,21 ,55, 55, 32 ,74, 60 ,32 ,87, 72 ,54};
        int[] end = {126 ,112 ,134 ,138, 89 ,118 ,107 ,124 ,126, 83 ,133, 64, 124 ,109 ,108 ,132 ,111 ,95 ,82, 106, 86 ,118,82 ,78, 92 ,55, 128, 121, 118 ,95 ,94 ,110 ,111 ,146 ,124, 148 ,95 ,146, 109 ,61, 93 ,126 ,74 ,76 ,110, 78 ,91};

        System.out.println(maxMeetings(start, end, start.length));
    }
}


/*
* 86 32 31 98 37 65 98 71 99 58 59 32 52 69 15 75 4 86 57 36 83 18 58 50 43 29 98 53 80 5 89 73 8 97 17 100 9 21 55 55 32 74 60 32 87 72 54
126 112 134 138 89 118 107 124 126 83 133 64 124 109 108 132 111 95 82 106 86 118 82 78 92 55 128 121 118 95 94 110 111 146 124 148 95 146 109 61 93 126 74 76 110 78 91
*/