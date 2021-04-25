package Algorithms;

import java.util.Scanner;

public class DSU {

    public static int superParent(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        return superParent(parent[node], parent);
    }

    // find superParent using path compression method
    public static int superParentBetter(int node, int[] parent) {
        if(node == parent[node]) {
            return node;
        }

        return parent[node] = superParent(parent[node], parent);
    }


    // useful when we want to detect on addition of which edge cycle is caused
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // a should be larger than b so that super parent can be updated nicely
            if(a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int aSuperParent = superParent(a, parent);
            int bSuperParent = superParent(b, parent);

            if(aSuperParent == bSuperParent) {
                System.out.println("Cycle detected");
                break;
            }

            parent[a] = bSuperParent;

        }
    }
}
