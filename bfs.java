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