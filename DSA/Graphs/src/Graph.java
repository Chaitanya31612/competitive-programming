import java.util.*;

public class Graph {


    /*===============================================================*/
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

    private static int maxArr(int[] arr, int si, int ei) {
        int max = Integer.MIN_VALUE;

        for(int i = si; i <= ei; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int groupScore(int[] arr, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = connectedComponentsDFS(edges);

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < list.size(); i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < list.get(i).size(); j++) {
                max = Math.max(max, arr[list.get(i).get(j)]);
            }

            int num = list.get(i).size() - 1;
            int newAns = max + num;


            ans = Math.max(ans, newAns);
        }

        return ans;
    }
    /*===============================================================*/


    public static ArrayList<ArrayList<Integer>> connectedComponentsDFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                ArrayList<Integer> sublist = new ArrayList<>();
                list.add(connectedComponentsDFS(edges, i, visited, sublist));
            }
        }
        return list;
    }

    private static ArrayList<Integer> connectedComponentsDFS(int[][] edges, int sv, boolean[] visited, ArrayList<Integer> sublist) {
        sublist.add(sv);
        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                connectedComponentsDFS(edges, i, visited, sublist);
            }
        }

        return sublist;
    }


    /*======================== isConnected========================*/
    public static boolean isConnected(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        DFS(edges, 0, visited);

        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void DFS(int[][] edges, int sv, boolean[] visited) {
        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                DFS(edges, i, visited);
            }
        }
    }

    /*=============================================================*/


    /* ==============================getpathbfs===========================*/
    // shortest path
    public static ArrayList<Integer> getPathBFS(int[][] edges, int s, int d) {
        if(s == d) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(s);
            return list;
        }

        int temps = s;
        boolean[] visited = new boolean[edges.length];

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        queue.add(s);
        visited[s] = true;


        while (!queue.isEmpty()) {
            s = queue.poll();

            for(int i = 0; i < edges.length; i++) {
                if(edges[s][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    map.put(i, s);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
//        System.out.println(map);
        if(map.containsKey(d)) {
            while(d != temps) {
                list.add(0, d);
                d = map.get(d);
            }
            if(!list.isEmpty()) {
                list.add(0, temps);
            }
            return list;
        } else {
            return null;
        }
    }
    /*===========================================================*/



    /*=====================getpathdfs===============================*/
    // longest path
    public static ArrayList<Integer> getPathDFS(int[][] edges, int s, int d) {
        boolean[] visited = new boolean[edges.length];
        return getPathDFS(edges, s, d, visited);
    }

    private static ArrayList<Integer> getPathDFS(int[][] edges, int s, int d, boolean[] visited) {
        if(s == d) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(d);
            return list;
        }

        visited[s] = true;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            if(edges[s][i] == 1 && !visited[i]) {
                list = getPathDFS(edges, i, d, visited);
            }
            if(list != null && !list.isEmpty()) {
                break;
            }
        }
        if(list != null && !list.isEmpty()) {
            list.add(0, s);
            return list;
        } else {
            return null;
        }
    }

    /*========================================================*/



    /*===========================haspathdfs======================================*/
    // O(V + E)
    public static boolean hasPathDFS(int[][] edges, int s, int d, boolean[] visited) {
        if(s == d) {
            return true;
        }

        visited[s] = true;

        boolean ans = false;
        for(int i = 0; i < edges.length; i++) {
            if(edges[s][i] == 1 && !visited[i]) {
                ans = hasPathDFS(edges, i, d, visited);
            }
        }

        return ans;
    }

    public static boolean hasPathDFS(int[][] edges, int s, int d) {
        boolean[] visited = new boolean[edges.length];

        return hasPathDFS(edges, s, d, visited);
    }

    /*===============================================================*/


    /*============================haspathbfs============================*/

    // s - source, d - destination
    public static boolean hasPath(int[][] edges, int s, int d) {
        boolean[] visited = new boolean[edges.length];
        if(s == d) {
            return true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            s = queue.poll();
            for(int i = 0; i < edges.length; i++) {
                if(i == d && edges[s][i] == 1) {
                    return true;
                }

                // else do bfs
                if(edges[s][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        // if reached here
        return false;
    }

    /*==============================================================*/


    /*==========================printbfs============================*/
    private static void printBFS(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;

        while(!queue.isEmpty()) {
            sv = queue.poll();
            System.out.println(sv);
            for(int i = 0; i < edges.length; i++) {
                if(edges[sv][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void printBFS(int[][] edges) {
        // boolean array is false by default
        boolean[] visited = new boolean[edges.length];

        // this for loop is used for a graph in which there may be more than one connected components
        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                printBFS(edges, i, visited);
            }
        }
    }

    /*===============================================================*/



    /* printDFS */
    private static void printDFS(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;

        for(int i = 0; i < edges.length; i++) {
            if(edges[sv][i] == 1 && !visited[i]) {
                printDFS(edges, i, visited);
            }
        }
    }

    public static void printDFS(int[][] edges) {
        // boolean array is false by default
        boolean[] visited = new boolean[edges.length];

        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                printDFS(edges, i, visited);
            }
        }
    }

    public static void printMatrix(int[][] edges) {
        int m = edges.length;
        int n = edges[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n - no of nodes
        // e - no of edges

        System.out.println("Enter number of vertex");
        int n = sc.nextInt();
        System.out.println("Enter number of edges");
        int e = sc.nextInt();

        int[][] edges = new int[n][n];

        for(int i = 0; i < e; i++) {
            System.out.println("Enter vertices");
            int fv = sc.nextInt();
            int sv = sc.nextInt();

            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }

        System.out.println("DFS");
        printDFS(edges);

        System.out.println("BFS");
        printBFS(edges);

        System.out.println("Has Path");
        System.out.println(hasPath(edges, 1, 3));
        System.out.println(hasPathDFS(edges, 1, 3));

        ArrayList<Integer> pathDFS = getPathDFS(edges, 1, 3);
        if(pathDFS != null) {
            System.out.println(pathDFS);
        }

        ArrayList<Integer> pathBFS = getPathBFS(edges, 1, 3);
        if(pathBFS != null) {
            System.out.println(pathBFS);
        }

        System.out.println("isConnected " + isConnected(edges));


        System.out.println(connectedComponentsDFS(edges));


    }
}
