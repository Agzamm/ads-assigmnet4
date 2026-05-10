import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        vertices = new HashMap<>();
        adjList  = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");
        for (int id : adjList.keySet()) {
            System.out.println("  " + vertices.get(id) + " -> " + adjList.get(id));
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS from " + start + ": ");

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor : adjList.get(curr)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS from " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int curr, Set<Integer> visited) {
        visited.add(curr);
        System.out.print(curr + " ");

        for (int neighbor : adjList.get(curr)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public Set<Integer> getVertexIds() {
        return vertices.keySet();
    }
}