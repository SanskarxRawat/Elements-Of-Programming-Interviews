import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MakingWiredConnections {


    /**
     * Design an algorithm that takes a set of pins and a set of wires connecting pairs of
     * pins, and determines if it is possible to place some pins on the left half of a PCB, and
     * the remainder on the right half, such that each wire is between left and right halves.
     * Return such a division, if one exists.
     * <p>
     * Approach:
     * - Treat the problem as a graph problem:
     * - Pins represent nodes.
     * - Wires represent edges between nodes.
     * - This is equivalent to checking if the graph is bipartite.
     * - A bipartite graph can be divided into two groups such that no two nodes in the same group are connected.
     * <p>
     * - Algorithm:
     * 1. Use Breadth-First Search (BFS) to check bipartiteness:
     * - Assign every node to one of two groups (e.g., group 0 or group 1).
     * - If there is a conflict while assigning (an edge exists between two nodes in the same group),
     * the graph is not bipartite.
     * 2. If the graph is bipartite, return the two groups.
     * Otherwise, return null.
     * <p>
     * Time Complexity: O(V + E), where V is the number of pins and E is the number of wires.
     * Space Complexity: O(V + E) due to storing the graph and visited state.
     */
    public static List<List<Integer>> dividePins(int n, int[][] wires) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        int[] colors = new int[n]; // 0 = unvisited, 1 = group 1, -1 = group 2
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !isBipartite(graph, i, colors)) {
                return null; // Graph is not bipartite
            }
        }

        // Collect pins into two groups
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (colors[i] == 1) {
                group1.add(i);
            } else if (colors[i] == -1) {
                group2.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(group1);
        result.add(group2);
        return result;
    }

    private static boolean isBipartite(List<List<Integer>> graph, int node, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1; // Assign to group 1

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : graph.get(curr)) {
                if (colors[neighbor] == 0) {
                    // Assign the opposite group to the neighbor
                    colors[neighbor] = -colors[curr];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[curr]) {
                    // Conflict found, graph is not bipartite
                    return false;
                }
            }
        }
        return true;
    }


    
}
