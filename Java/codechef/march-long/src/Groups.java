import java.util.Scanner;

public class Groups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0) {
            String str = sc.nextLine();
            int[] arr = new int[str.length()];
            for(int i = 0; i < str.length(); i++) {
                int val = Integer.parseInt(str.substring(i, i+1));
                arr[i] = val;
            }

            int group = 0;
//            int i = 0;
//            while(i < arr.length) {
//                if(arr[i] == 0) {
//                    i++;
//                    continue;
//                } else if(arr[i] == 1){
//                    int count = 1;
//                    while(i+1 < arr.length && arr[++i] == 1) {
//                        count++;
//                    }
//                    if(count > 1)
//                        group += 1;
////                    if(i+1 < arr.length && arr[i+1] == 1) {
////                        group++;
////                        i+=2;
////                    }
//                    else {
//                        group++;
//                        i++;
//                    }
//                }
//            }

            boolean checkFriend = false;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == 1 && !checkFriend) {
                    checkFriend = true;
                    group++;
                } else if(arr[i] == 0) {
                    checkFriend = false;
                }
            }
            System.out.println(group);
        }
    }
}
