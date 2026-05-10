import java.util.Random;

public class Experiment {
    private long[][] results;
    private int[] sizes = {10, 30, 100};

    public Experiment() {
        results = new long[sizes.length][2];
    }


    public long[] runTraversals(Graph g) {
        int startId = g.getVertexIds().iterator().next();

        long bfsStart = System.nanoTime();
        g.bfs(startId);
        long bfsEnd = System.nanoTime();

        long dfsStart = System.nanoTime();
        g.dfs(startId);
        long dfsEnd = System.nanoTime();

        return new long[]{bfsEnd - bfsStart, dfsEnd - dfsStart};
    }

    public void runMultipleTests() {
        Random rand = new Random(42);

        for (int i = 0; i < sizes.length; i++) {
            int n = sizes[i];
            Graph g = buildRandomGraph(n, rand);

            System.out.println("Graph size: " + n + " vertices");
            long[] times = runTraversals(g);
            results[i][0] = times[0];
            results[i][1] = times[1];
        }
    }


    public void printResults() {
        System.out.printf("%-12s %-18s %-18s%n", "Vertices", "BFS Time (ns)", "DFS Time (ns)");
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%-12d %-18d %-18d%n", sizes[i], results[i][0], results[i][1]);
        }
    }

    private Graph buildRandomGraph(int n, Random rand) {
        Graph g = new Graph();
        for (int i = 0; i < n; i++) g.addVertex(new Vertex(i));

        int edgeCount = n * 2;
        int added = 0;
        while (added < edgeCount) {
            int from = rand.nextInt(n);
            int to   = rand.nextInt(n);
            if (from != to) {
                g.addEdge(from, to);
                added++;
            }
        }
        return g;
    }
}