public class Bellmanford {
    
}


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
            
            // Traverse all sorted neighbors of the current node
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

        // Sort the adjacency list to visit neighbors in ascending order
        for (int i = 0; i < V; i++) {
            Collections.sort(adj.get(i));
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




//hackerank

// import java.io.*;
// import java.util.*;

public class Solution {

    // Bellman-Ford algorithm to find shortest paths
    public static void bellmanFord(int V, ArrayList<int[]>[] adj) {
        int[] dist = new int[V]; // Distance array
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize all distances as infinity
        dist[0] = 0; // Distance from the source (0) to itself is 0
        
        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (int[] edge : adj[u]) {
                    int v = edge[0];
                    int weight = edge[1];
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }
        
        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println(-1); // Negative cycle detected
                    return;
                }
            }
        }
        
        // Print the shortest distances or -1 if no path exists
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(dist[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of vertices and edges
        String[] nm = br.readLine().split(" ");
        int V = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // Initialize adjacency list
        ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < M; i++) {
            String[] edgeData = br.readLine().split(" ");
            int u = Integer.parseInt(edgeData[0]);
            int v = Integer.parseInt(edgeData[1]);
            int w = Integer.parseInt(edgeData[2]);
            adj[u].add(new int[]{v, w});
        }

        // Run Bellman-Ford algorithm
        bellmanFord(V, adj);
    }
}
