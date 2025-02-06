import java.util.List;

public class DeadlockDetection {


    /**
     * Write a program that takes as input a directed graph and checks if the graph contains
     * a cycle.
     * <p>
     * Intuition:
     * We represent the graph as an adjacency list where each node points to a list of its neighbors.
     * To detect a cycle, we perform Depth-First Search (DFS) on each node. If we revisit a node that
     * is already in the current recursion stack, a cycle is detected. We use two arrays:
     * - `visited` to mark if a node has been visited.
     * - `recStack` to keep track of nodes in the current recursion stack.
     * <p>
     * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V) for the visited and recursion stack arrays.
     */

    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicDFS(i, adj, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicDFS(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && isCyclicDFS(neighbor, adj, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false; // Remove the node from the recursion stack
        return false;
    }


    /

    /**
     * Write a program that takes as input an undirected graph and checks if the graph contains
     * a cycle.
     * <p>
     * Intuition:
     * In an undirected graph, a cycle exists if during DFS traversal we revisit a visited node
     * that is not the direct parent of the current node.
     * We reuse the `visited` array and remove the `recStack` array as it is not needed here.
     * <p>
     * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V) for the recursion stack and visited array.
     */

    public static boolean hasCycleUndirected(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicDFSUndirected(i, -1, adj, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclicDFSUndirected(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicDFSUndirected(neighbor, node, adj, visited)) {
                    return true;
                }
            } else if (neighbor != parent) { // Check if visited neighbor is not the parent
                return true;
            }
        }

        return false;
    }
}
