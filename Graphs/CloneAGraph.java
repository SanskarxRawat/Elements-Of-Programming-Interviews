import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneAGraph {


    /**
     * Design an algorithm that takes a reference to a vertex u, and creates a copy of the graph on the vertices reachable from
     * u. Return the copy of u.
     *
     * Intuition:
     * 1. Use Breadth-First Search (BFS) or Depth-First Search (DFS) to traverse the graph.
     * 2. Maintain a mapping from each node in the original graph to the corresponding node in the cloned graph.
     * 3. For each node in the original graph:
     * - Create a copy of the node if it does not already exist in the map.
     * - Copy all the neighbors by recursively cloning or iteratively processing them.
     * <
     * Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V) for the map used to store clones and call stack (in case of DFS).
     */
    public static class GraphNode {
        int val;
        List<GraphNode> neighbors;

        public GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        Map<GraphNode, GraphNode> map = new HashMap<>();
        return dfsClone(node, map);
    }

    private static GraphNode dfsClone(GraphNode node, Map<GraphNode, GraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        GraphNode clone = new GraphNode(node.val);
        map.put(node, clone);

        for (GraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfsClone(neighbor, map));
        }

        return clone;
    }


    
}
