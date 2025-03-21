//leetcode
class toposort {//Topological sort
    //https://www.geeksforgeeks.org/problems/topological-sort/1    
        
        // Function to return list containing vertices in Topological order.
        static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
            int V = adj.size();
            return topoSort(V, adj);
        }
    
        private static void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
            vis[node] = true;
            for (int it : adj.get(node)) {
                if (!vis[it]) {
                    dfs(it, vis, st, adj);
                }
            }
            st.push(node);
        }
    
        private static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
            boolean[] vis = new boolean[V];
            Stack<Integer> st = new Stack<>();
    
            for (int i = 0; i < V; i++) {
                if (!vis[i]) {
                    dfs(i, vis, st, adj);
                }
            }
    
            ArrayList<Integer> ans = new ArrayList<>();
            while (!st.isEmpty()) {
                ans.add(st.pop());
            }
            return ans;
        }
    }


//hackerank (not there)
