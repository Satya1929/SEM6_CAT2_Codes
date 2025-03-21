//leetcode
import java.util.* ;

class bfs {//BFS of graph
    //https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
        public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            ArrayList<Integer> bfs = new ArrayList<>(); // Result list
            boolean[] visited = new boolean[V]; // Visited array
        
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0); // Start BFS from node 0
            visited[0] = true;
        
            while (!queue.isEmpty()) {
                int node = queue.poll();
                bfs.add(node); // Add current node to BFS result
        
                // Traverse all neighbors of the current node
                for (int neighbour : adj.get(node)) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                        queue.add(neighbour);
                    }
                }
            }
            return bfs;
        }
    }



//hackerank
// import java.io.*;
// import java.util.*;

public class Solution {

    // BFS implementation of the graph
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>(); // Result list
        boolean[] visited = new boolean[V]; // Visited array
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Start BFS from node 0
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.add(node); // Add current node to BFS result
            
            // Traverse all neighbors of the current node
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of vertices
        int V = Integer.parseInt(br.readLine().trim());
        
        // If there are no vertices
        if (V == 0) {
            System.out.println("Graph doesn't exist");
            return;
        }

        // Initialize the adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Read edges until the "-1 -1" edge is encountered
        while (true) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);

            if (u == -1 && v == -1) {
                break; // Stop reading edges when -1 -1 is encountered
            }

            // Add the edge to the adjacency list (undirected graph)
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Get the BFS traversal starting from vertex 0
        ArrayList<Integer> bfsResult = bfsOfGraph(V, adj);

        // Print the BFS traversal
        System.out.print("BFS :");
        for (int node : bfsResult) {
            System.out.print(" " + node);
        }
        System.out.println();
    }
}
