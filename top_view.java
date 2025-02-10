import java.util.*;

public class top_view {//Top View of Binary Tree
    //https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

    // Custom class to hold a node and its vertical position
    static class Pair {
        Node node;
        int line;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>(); // TreeMap to store first node at each vertical line

        // Queue for BFS traversal storing node along with vertical level
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        // BFS traversal
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int line = current.line;

            // Insert node if vertical position not seen before
            if (!map.containsKey(line)) map.put(line, node.data);

            // Process left child
            if (node.left != null) queue.add(new Pair(node.left, line - 1));
            // Process right child
            if (node.right != null) queue.add(new Pair(node.right, line + 1));
        }

        result.addAll(map.values());
        return result;
    }
}