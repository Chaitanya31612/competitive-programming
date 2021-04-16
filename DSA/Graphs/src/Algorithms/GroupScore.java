package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class GroupScore {

    public static void GroupProblem() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num+1];
        for(int i = 1; i <= num; i++) {
            arr[i] = sc.nextInt();
        }


        int n = num + 1;
        int e = sc.nextInt();

        int[][] edges = new int[n][n];

        for(int i = 0; i < e; i++) {
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }

        System.out.println(groupScore(arr, edges));
    }

    static class PairGroup {
        int count;
        ArrayList<Integer> list;
    }

    public static int groupScore(int[] arr, int[][] edges) {
        ArrayList<PairGroup> p = groupDFS(edges);

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < p.size(); i++) {
            PairGroup p1 = p.get(i);
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < p1.list.size(); j++) {
                max = Math.max(max, arr[p1.list.get(j)]);
            }

            int num = p1.count / 2;
            int newAns = max + num;


            ans = Math.max(ans, newAns);
        }

        return ans;
    }



    public static ArrayList<PairGroup> groupDFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];

        int[] count = new int[1];

        ArrayList<PairGroup> p = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                ArrayList<Integer> sublist = new ArrayList<>();
                groupDFS(edges, i, visited, sublist, count);
                PairGroup p1 = new PairGroup();
                p1.count = count[0];
                p1.list = sublist;
                p.add(p1);
            }
        }


        return p;
    }

    private static ArrayList<Integer> groupDFS(int[][] edges, int sv, boolean[] visited,
                                               ArrayList<Integer> sublist, int[] count) {
        sublist.add(sv);
        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                groupDFS(edges, i, visited, sublist, count);
                count[0] += 1;
            }
        }

        return sublist;
    }

    public static void main(String[] args) {
        GroupProblem();
    }
}
