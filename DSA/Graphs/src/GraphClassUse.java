public class GraphClassUse {
    public static void main(String[] args) {

        /* Integer graph */
//        GraphClass<Integer> g1 = new GraphClass<>();
//        g1.addEdge(0, 1, true);
//        g1.addEdge(1, 2, true);
//        g1.addEdge(2, 3, true);
//        g1.addEdge(3, 4, true);
//        g1.addEdge(4, 0, true);
//        g1.print();
//        g1.bfs(0);
//        g1.dfs(0);
//        g1.singleShortestPath(0);

        /* String graph */
//        GraphClass<String> g2 = new GraphClass<>();
//        g2.addEdge("A", "B", true);
//        g2.addEdge("B", "C", true);
//        g2.addEdge("C", "D", true);
//        g2.addEdge("D", "E", true);
//        g2.addEdge("E", "A", true);
//        g2.print();
//        g2.bfs("A");
//        g2.dfs("A");


//        GraphClass<String> city = new GraphClass<>();
//        city.addEdge("Amritsar", "Jaipur", true);
//        city.addEdge("Amritsar", "Delhi", true);
//        city.addEdge("Delhi", "Jaipur", true);
//        city.addEdge("Mumbai", "Jaipur", true);
//        city.addEdge("Mumbai", "Bhopal", true);
//        city.addEdge("Andaman", "Nicobar", true);
//        city.print();
//        city.bfs("Amritsar");
//        city.dfs("Amritsar");



        /* Snakes and ladder problem */
//        GraphClass<Integer> g3 = new GraphClass<>();
//
//        int[] board = new int[50];
//        // board array will contain what should be added when reached that index
//        board[2] = 13;
//        board[5] = 2;
//        board[9] = 18;
//        board[18] = 11;
//        board[17] = -13;
//        board[20] = -14;
//        board[24] = -8;
//        board[25] = -10;
//        board[32] = -2;
//        board[34] = -22;
//
//        // let suppose the number on snake and ladder game is till 36
//        for(int u = 0; u <= 36; u++) {
//            for(int dice = 1; dice <= 6; dice++) {
//                int v = u + dice + board[u + dice];
//                g3.addEdge(u, v, false);
//            }
//        }
//
//        System.out.println("The shortest distance is " + g3.snakesAndLadderUtil(1, 36));



        /* Topological Sort */
        GraphClass<Integer> gTop = new GraphClass<>();
        gTop.addEdge(1, 2, false);
        gTop.addEdge(1, 3, false);
        gTop.addEdge(2, 4, false);
        gTop.addEdge(3, 4, false);
        gTop.dfsTopologicalSort();
        gTop.bfsTopologicalSort();
    }


}
