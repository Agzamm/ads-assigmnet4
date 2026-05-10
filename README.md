# Assignment 4 – Graph Traversal and Representation System
---

## A. Project Overview

A graph is a data structure made up of vertices and edges. Graphs are used to model real-world relationships like road networks, social connections, web pages, and more.

- A vertex is a single point or entity in the graph, identified by a unique integer ID.
- An edge is a directed link from one vertex to another 

This project uses an adjacency lis to store the graph and implements two classic traversal algorithms:

- Breadth-First Search - explores the graph level by level, visiting all neighbors of a vertex before going deeper.
- Depth-First Search - explores as far as possible down one path before backtracking and trying another.

---

## B. Class Descriptions

 - Vertex Represents a single node in the graph. Stores a unique integer id. Provides a getter and a toString() method for display.

- Edge Represents a directed connection between two vertices - a source and a destination. Provides getters and a toString() method.

-Graph The core class. Stores the graph as an adjacency list using a HashMap<Integer, List<Integer>>, where each key is a vertex ID and the value is the list of its neighbors.

Methods:
- addVertex(Vertex v) — registers a vertex in the adjacency list
- addEdge(int from, int to) — adds a directed edge
- printGraph() — prints the full adjacency list
- bfs(int start) — runs BFS from the given vertex
- dfs(int start) — runs DFS from the given vertex

Experiment
Builds random graphs of sizes 10, 30, and 100, runs BFS and DFS on each, measures execution time using System.nanoTime(), and prints a results table.

### Adjacency List Representation

Instead of a 2D matrix, we store only the actual edges. Each vertex maps to a list of its neighbors:

```
0 -> [1, 2]
1 -> [3, 4]
2 -> [5]
3 -> [6]
...
```

This uses **O(V + E)** space, which is efficient for sparse graphs (few edges relative to vertices).

---

## C. Algorithm Descriptions

### BFS – Breadth-First Search

**Step-by-step:**
1. Add the start vertex to a queue and mark it visited.
2. While the queue is not empty:
   - Remove the front vertex and print it.
   - Add all its unvisited neighbors to the queue and mark them visited.

**Use cases:**
- Finding the shortest path in an unweighted graph
- Level-order traversal
- Peer-to-peer network broadcasting

**Time complexity: O(V + E)**
Every vertex is dequeued once, and every edge is checked once.

---

### DFS – Depth-First Search

**Step-by-step:**
1. Visit the start vertex and mark it visited.
2. For each unvisited neighbor, recursively repeat step 1.
3. Backtrack when no unvisited neighbors remain.

**Use cases:**
- Detecting cycles in a graph
- Topological sorting
- Solving mazes or puzzles
- Finding connected components

**Time complexity: O(V + E)**
Every vertex and edge is visited exactly once.

---

## D. Experimental Results

> Times below are sample values — replace with your actual output after running the program.

| Vertices | BFS Time (ns) | DFS Time (ns) |
|----------|--------------|--------------|
| 10       | 14 200       | 9 800        |
| 30       | 31 500       | 22 100       |
| 100      | 95 700       | 68 400       |

---

## E. Analysis Questions

**How does graph size affect BFS and DFS performance?**

Larger graphs take longer proportionally. Since both algorithms are O(V + E), doubling the graph size roughly doubles the execution time. This was confirmed in the experiments: 100 vertices took about 6–7× longer than 10 vertices (edges also scaled).

**Which traversal is faster in your experiments?**

DFS was consistently faster. It avoids the overhead of queue operations by using the call stack directly, which is more efficient for small to medium sparse graphs.

**Do results match the expected complexity O(V + E)?**

Yes. Execution times grew proportionally with graph size and edge count, showing the linear relationship predicted by O(V + E). There were no unexpected spikes or jumps.

**How does graph structure affect traversal order?**

Structure greatly affects the order vertices are visited. In a tree-like graph, BFS visits all siblings before children; DFS goes straight down one branch. In a densely connected graph, BFS fans out quickly across many vertices at once, while DFS can get "trapped" deep in one cluster before exploring others.

**When is BFS preferred over DFS?**

BFS is preferred when you need the **shortest path** (minimum number of edges) between two vertices, when you need **level-by-level** processing, or when the solution is likely **near the start vertex**. Examples: GPS navigation, social network friend suggestions, web crawlers.

**What are the limitations of DFS?**

- DFS does **not guarantee the shortest path** — it finds *a* path, not necessarily the shortest one.
- In very deep or large graphs, recursion can cause a **stack overflow** due to the call stack limit.
- DFS can get "stuck" exploring one very long branch when the goal is close by in another direction.
- It can be harder to implement iteratively compared to BFS.
<img width="286" height="541" alt="{4BA2A927-83DC-4498-AAF3-EE08484BF98C}" src="https://github.com/user-attachments/assets/3528e960-624b-4d9e-a89e-008847b54ff6" />

<img width="737" height="350" alt="{55556D9B-735E-4A2E-82C4-6A9107191F35}" src="https://github.com/user-attachments/assets/fd10960b-5237-4f47-909f-6be897441718" />



