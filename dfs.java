import java.util.*;

public class dfs {//
//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

    // Helper method to perform DFS
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node); // Add current node to the result

        // Traverse all neighbors of the current node
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); // Number of vertices
        boolean[] visited = new boolean[V]; // Visited array
        ArrayList<Integer> result = new ArrayList<>();

        // Start DFS from node 0
        dfs(0, adj, visited, result);
        return result;
    }
}
