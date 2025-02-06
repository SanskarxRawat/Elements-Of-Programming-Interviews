import java.util.HashMap;
import java.util.PriorityQueue;

public class ComputeShortestPathFewEdges {


    /**
     * Approach:
     * This problem can be solved using a modified Breadth-First Search (BFS) with a priority queue.
     * We use a priority queue to always explore the shortest paths first based on cost.
     * Additionally, we keep track of the edge count for each path to ensure we find the
     * shortest path with the fewest edges when there is a tie in total cost.
     * <p>
     * Steps:
     * 1. Define a custom class `Path` to store the current vertex, path cost, and edge count.
     * 2. Use a priority queue where each entry is a `Path` object.
     * 3. Track the minimum cost and corresponding edge count for each vertex using a hashmap.
     * 4. During BFS, if a better path (lower cost or fewer edges at the same cost) is found,
     * update the map and continue exploring neighbors.
     * 5. Stop the search once the target vertex is dequeued with the optimal path.
     * <p>
     * Time Complexity: O((V + E) * log V), where V is the number of vertices and E is the number of edges.
     * - The log V factor comes from operations with the priority queue.
     * Space Complexity: O(V + E) for storing the graph, queue, and visited map.
     */


    public static int computeShortestPathWithFewestEdges(
            int[][] graph, int start, int end) {
        class Path implements Comparable<Path> {
            int vertex, cost, edges;

            Path(int vertex, int cost, int edges) {
                this.vertex = vertex;
                this.cost = cost;
                this.edges = edges;
            }

            @Override
            public int compareTo(Path other) {
                if (this.cost != other.cost) return Integer.compare(this.cost, other.cost);
                return Integer.compare(this.edges, other.edges);
            }
        }

        PriorityQueue<Path> pq = new PriorityQueue<>();
        HashMap<Integer, int[]> visited = new HashMap<>();

        pq.offer(new Path(start, 0, 0));
        visited.put(start, new int[]{0, 0});

        while (!pq.isEmpty()) {
            Path current = pq.poll();

            if (current.vertex == end) {
                return current.cost;
            }

            for (int neighbor = 0; neighbor < graph[current.vertex].length; neighbor++) {
                int edgeCost = graph[current.vertex][neighbor];
                if (edgeCost > 0) {
                    int newCost = current.cost + edgeCost;
                    int newEdges = current.edges + 1;

                    if (!visited.containsKey(neighbor)
                            || newCost < visited.get(neighbor)[0]
                            || (newCost == visited.get(neighbor)[0]
                            && newEdges < visited.get(neighbor)[1])) {
                        visited.put(neighbor, new int[]{newCost, newEdges});
                        pq.offer(new Path(neighbor, newCost, newEdges));
                    }
                }
            }
        }

        return -1; // No path found
    }
  


}
