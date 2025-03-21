import java.util.* ;

class bottom_view//Bottom View of Binary Tree
//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
{
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store the bottom-most node at each vertical line
        Map<Integer, Integer> map = new TreeMap<>();
        
        // Queue for BFS traversal storing node and its horizontal distance
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll(); // poll instead of front
            Node node = current.node;
            int line = current.line;

            // Update the map with the latest node at the same horizontal distance
            map.put(line, node.data); //overwrite the previous data hence store bottomost value

            // Process left and right children
            if (node.left != null) queue.add(new Pair(node.left, line - 1));
            if (node.right != null) queue.add(new Pair(node.right, line + 1));
        }

        result.addAll(map.values());
        return result;
    }

    // Helper class to store a node along with its horizontal distance
    static class Pair {
        Node node;
        int line;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }
}