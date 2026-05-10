public class Main {
    public static void main(String[] args) {

        System.out.println("Small Graph:");
        Graph small = new Graph();
        for (int i = 0; i < 10; i++) small.addVertex(new Vertex(i));

        int[][] edges = {
                {0,1},{0,2},{1,3},{1,4},{2,5},{3,6},{4,6},{5,7},{6,8},{7,9},{8,9}
        };
        for (int[] e : edges) small.addEdge(e[0], e[1]);

        small.printGraph();
        System.out.println();

        long s = System.nanoTime();
        small.bfs(0);
        long bfsTime = System.nanoTime() - s;

        s = System.nanoTime();
        small.dfs(0);
        long dfsTime = System.nanoTime() - s;

        System.out.println("BFS time: " + bfsTime + " ns");
        System.out.println("DFS time: " + dfsTime + " ns");

        Experiment exp = new Experiment();
        exp.runMultipleTests();
        exp.printResults();
    }
}