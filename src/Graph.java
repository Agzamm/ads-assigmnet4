import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addVertex(Vertex v) {
        adjList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }

    public void printGraph() {
        for (int id : adjList.keySet())
            System.out.println(id + " -> " + adjList.get(id));
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");
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
        System.out.print("DFS: ");
        dfsHelper(start, new HashSet<>());
        System.out.println();
    }

    private void dfsHelper(int curr, Set<Integer> visited) {
        visited.add(curr);
        System.out.print(curr + " ");
        for (int neighbor : adjList.get(curr))
            if (!visited.contains(neighbor))
                dfsHelper(neighbor, visited);
    }

    public Set<Integer> getVertexIds() { return adjList.keySet(); }
}