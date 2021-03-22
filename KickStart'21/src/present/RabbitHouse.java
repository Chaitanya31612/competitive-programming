package present;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RabbitHouse {

    public static void rightUpdate(int[][] arr, int i, int j, int diff) {
        if(arr[i][j] < arr[i][j+1]) {
            arr[i][j] = diff - 1;
        } else {
            arr[i][j+1] = diff - 1;
        }
    }
    public static void leftUpdate(int[][] arr, int i, int j, int diff) {
        if(arr[i][j] < arr[i][j-1]) {
            arr[i][j] = diff - 1;
        } else {
            arr[i][j-1] = diff - 1;
        }
    }
    public static void downUpdate(int[][] arr, int i, int j, int diff) {
        if(arr[i][j] < arr[i+1][j]) {
            arr[i][j] = diff - 1;
        } else {
            arr[i+1][j] = diff - 1;
        }
    }
    public static void upUpdate(int[][] arr, int i, int j, int diff) {
        if(arr[i][j] < arr[i-1][j]) {
            arr[i][j] = diff - 1;
        } else {
            arr[i-1][j] = diff - 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] arr = new int[r][c];

            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int ans = 0;
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    boolean right = j+1 < c;
                    boolean left = j-1 >= c;
                    boolean up = i-1 >= 0;
                    boolean down = i+1 < r;

                    int diff = 0;
                    if(i == 0) {
                        if(j == 0) {
                            // right down
                            if(right) {
                                diff = Math.abs(arr[i][j] - arr[i][j+1]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    rightUpdate(arr, i, j, diff);
                                }
                            }
                            if(down) {
                                diff = Math.abs(arr[i][j] - arr[i+1][j]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    downUpdate(arr, i, j, diff);
                                }
                            }
                        } else {
                            // right down left
                            if(right) {
                                diff = Math.abs(arr[i][j] - arr[i][j+1]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    rightUpdate(arr, i, j, diff);
                                }

                            }
                            if(down) {
                                diff = Math.abs(arr[i][j] - arr[i+1][j]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    downUpdate(arr, i, j, diff);
                                }

                            }
                            if(left) {
                                diff = Math.abs(arr[i][j] - arr[i][j-1]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    leftUpdate(arr, i, j, diff);
                                }
                            }
                        }
                    }
                    else if(i == r-1) {

                        if(j == 0) {
                            // up right
                            if(right) {
                                diff = Math.abs(arr[i][j] - arr[i][j+1]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    rightUpdate(arr, i, j, diff);
                                }

                            }
                            if(up) {
                                diff = Math.abs(arr[i][j] - arr[i-1][j]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    upUpdate(arr, i, j, diff);
                                }

                            }
                        } else {
                            // right up left
                            if(right) {
                                diff = Math.abs(arr[i][j] - arr[i][j+1]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    rightUpdate(arr, i, j, diff);
                                }

                            }
                            if(up) {
                                diff = Math.abs(arr[i][j] - arr[i-1][j]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    upUpdate(arr, i, j, diff);
                                }
                            }
                            if(left) {
                                diff = Math.abs(arr[i][j] - arr[i][j-1]);
                                if(diff > 1) {
                                    ans += diff - 1;
                                    leftUpdate(arr, i, j, diff);
                                }
                            }
                        }
                    } else {
                        // right
                        if(right) {
                            diff = Math.abs(arr[i][j] - arr[i][j+1]);
                            if(diff > 1) {
                                ans += diff - 1;
                                rightUpdate(arr, i, j, diff);
                            }
                        }
                        // down
                        if(down) {
                            diff = Math.abs(arr[i][j] - arr[i+1][j]);
                            if(diff > 1) {
                                ans += diff - 1;
                                downUpdate(arr, i, j, diff);
                            }
                        }
                        // up
                        if(up) {
                            diff = Math.abs(arr[i][j] - arr[i-1][j]);
                            if(diff > 1) {
                                ans += diff - 1;
                                upUpdate(arr, i, j, diff);
                            }
                        }
                        //left
                        if(left) {
                            diff = Math.abs(arr[i][j] - arr[i][j-1]);
                            if(diff > 1) {
                                ans += diff - 1;
                                leftUpdate(arr, i, j, diff);
                            }
                        }
                    }
                }
            }

            System.out.println("Case #" + tt + ": " + ans);
        }
    }
}
