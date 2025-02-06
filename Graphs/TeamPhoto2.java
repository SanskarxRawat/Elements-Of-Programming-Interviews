import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TeamPhoto2 {


    /**
     * Design an algorithm that takes as input two teams and the heights of the players in
     * the teams and checks if it is possible to place players to take the photo subject to the
     * placement constraint. How would you generalize this problem, to determine
     * the largest number of teams that can be photographed simultaneously subject to the
     * same constraints?
     * <p>
     * Approach:
     * - For two teams:
     * - Sort both teams by height.
     * - Check if all players in one team are strictly taller than their counterparts in the other team.
     * - For multiple teams:
     * - Create a directed graph where each team is a node.
     * - Add a directed edge from team A to team B if all players in team A are taller than their counterparts in team B.
     * - Find the longest path in the directed graph to determine the maximum number of teams that can be photographed
     * simultaneously in order.
     * <p>
     * Time Complexity: O(t * n log n) to sort player heights (t = number of teams, n = number of players per team)
     * O(V + E) for building and traversing the graph (V = number of teams, E = number of edges).
     * Space Complexity: O(V + E) for storing the graph.
     */
    public static int maxTeamsPhotographed(List<int[]> teams) {
        int t = teams.size();
        int[][] graph = new int[t][t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (i != j && canPlaceBefore(teams.get(i), teams.get(j))) {
                    graph[i][j] = 1;
                }
            }
        }

        return findLongestPath(graph);
    }

    private static boolean canPlaceBefore(int[] teamA, int[] teamB) {
        Arrays.sort(teamA);
        Arrays.sort(teamB);

        for (int i = 0; i < teamA.length; i++) {
            if (teamA[i] >= teamB[i]) {
                return false;
            }
        }
        return true;
    }

    private static int findLongestPath(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        List<Integer> topologicalOrder = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTopologicalSort(graph, i, visited, topologicalOrder);
            }
        }

        Collections.reverse(topologicalOrder);

        int[] distances = new int[V];
        Arrays.fill(distances, 0);

        for (int u : topologicalOrder) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] == 1) {
                    distances[v] = Math.max(distances[v], distances[u] + 1);
                }
            }
        }

        return Arrays.stream(distances).max().orElse(0) + 1;
    }

    private static void dfsTopologicalSort(int[][] graph, int node, boolean[] visited, List<Integer> order) {
        visited[node] = true;

        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsTopologicalSort(graph, i, visited, order);
            }
        }

        order.add(node);
    }
}
