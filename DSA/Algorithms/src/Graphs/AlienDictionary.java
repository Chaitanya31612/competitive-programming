package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AlienDictionary {

    public void topologicalSortDFS(int s, ArrayList<ArrayList<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[s] = true;

        for(int neigh : graph.get(s)) {
            if(!visited[neigh]) {
                topologicalSortDFS(neigh, graph, visited, stack);
            }
        }

        stack.push(s);
    }

    public Stack<Integer> topologicalSort(ArrayList<ArrayList<Integer>> graph, int K) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[K];

        for(int i = 0; i < K; i++) {
            if(!visited[i]) {
                topologicalSortDFS(i, graph, visited, stack);
            }
        }

        return stack;
    }

    public String findOrder(String [] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            graph.add(new ArrayList<>());
        }

        String word1, word2;
        for(int i = 0; i < N - 1; i++) {
            word1 = dict[i];
            word2 = dict[i + 1];

            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        Stack<Integer> stack = topologicalSort(graph, K);
        String ans = "";
        while (!stack.isEmpty()) {
            ans = ans + (char)(stack.pop() + 'a');
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] words = new String[n];

        for(int i = 0; i < n; i++)
            words[i] = sc.next();

        AlienDictionary a = new AlienDictionary();
        System.out.println(a.findOrder(words, n, k));
    }
}
