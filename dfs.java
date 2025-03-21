
//leetcode
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



//hackerank
// import java.io.*;
// import java.util.*;

public class Solution {
    
    // Helper method to perform DFS
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
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
    public static ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n]; // Visited array
        ArrayList<Integer> result = new ArrayList<>();

        // Start DFS from node 0
        dfs(0, adj, visited, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the number of nodes and edges
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // Initialize the adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read the edges
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u); // Since the graph is undirected
        }

        // Get the DFS traversal
        ArrayList<Integer> result = dfsOfGraph(n, adj);

        // Print the result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
