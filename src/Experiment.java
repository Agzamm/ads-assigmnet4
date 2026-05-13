import java.util.Random;

public class Experiment {
    private int[] sizes = {10, 30, 100};
    private long[][] results = new long[3][2];

    public long[] runTraversals(Graph g) {
        int start = g.getVertexIds().iterator().next();

        long t1 = System.nanoTime(); g.bfs(start); long bfsTime = System.nanoTime() - t1;
        long t2 = System.nanoTime(); g.dfs(start); long dfsTime = System.nanoTime() - t2;

        return new long[]{bfsTime, dfsTime};
    }

    public void runMultipleTests() {
        Random rand = new Random(42);
        for (int i = 0; i < sizes.length; i++) {
            Graph g = buildGraph(sizes[i], rand);
            System.out.println("\n Size: " + sizes[i]);
            results[i] = runTraversals(g);
        }
    }

    public void printResults() {
        System.out.println("Results:");
        System.out.printf("%-10s %-15s %-15s%n", "Vertices", "BFS (ns)", "DFS (ns)");
        for (int i = 0; i < sizes.length; i++)
            System.out.printf("%-10d %-15d %-15d%n", sizes[i], results[i][0], results[i][1]);
    }

    private Graph buildGraph(int n, Random rand) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex(new Vertex(i));

        for (int i = 0; i < n - 1; i++) g.addEdge(i, i + 1);

        int extra = n * 2;
        int added = 0;
        while (added < extra) {
            int from = rand.nextInt(n);
            int to = rand.nextInt(n);
            if (from != to) {
                g.addEdge(from, to);
                added++;
            }
        }
        return g;
    }
}