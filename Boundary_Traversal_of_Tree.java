public class Boundary_Traversal_of_Tree {
    
}


//leetcode
class Solution {
    // Function to check if a node is a leaf
    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    // Function to add the left boundary of the tree
    void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data); // non-leaf check for consistency
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    // Function to add the right boundary of the tree
    void addRightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data); // non-leaf check for consistency
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        
        for (int i = temp.size() - 1; i >= 0; --i) { // or use stack
            res.add(temp.get(i));
        }
    }

    // Function to add the leaves of the tree
    void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    // Main function to perform the boundary traversal of the binary tree
    List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) return res; // empty tree
        
        if (!isLeaf(root)) res.add(root.data); // for consistency of approach below
        
        addLeftBoundary(root, res); // except leaf node
        addLeaves(root, res); // process leaf
        addRightBoundary(root, res); // except leaf node
        
        return res;
    }
}






//hackerrank
// import java.io.*;
// import java.util.*;

// Define the Node class
class Node {
    int data;
    Node left, right;

    // Constructor to initialize the node
    Node(int x) {
        data = x;
        left = right = null;
    }
}

public class Solution {

    // Function to check if a node is a leaf
    public static boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    // Function to add the left boundary (excluding leaf nodes)
    public static void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.data);  // Add non-leaf nodes
            // Move to the next boundary node (either left or right)
            curr = (curr.left != null) ? curr.left : curr.right;
        }
    }

    // Function to add the right boundary (excluding leaf nodes)
    public static void addRightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.data);  // Add non-leaf nodes
            // Move to the next boundary node (either right or left)
            curr = (curr.right != null) ? curr.right : curr.left;
        }

        // Add the right boundary in reverse order
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    // Function to add the leaf nodes (in left-to-right order)
    public static void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    // Main function for boundary traversal
    public static List<Integer> boundaryTraversal(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;  // Empty tree

        if (!isLeaf(root)) res.add(root.data);  // Add root if not a leaf

        addLeftBoundary(root, res);  // Add the left boundary (excluding leaves)
        addLeaves(root, res);        // Add all leaf nodes
        addRightBoundary(root, res); // Add the right boundary (excluding leaves)

        return res;
    }

    // Function to build the binary tree from level-order input
    public static Node buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("-1")) return null;

        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < input.length) {
            Node curr = queue.poll();

            // Left child
            if (i < input.length && !input[i].equals("-1")) {
                curr.left = new Node(Integer.parseInt(input[i]));
                queue.add(curr.left);
            }
            i++;

            // Right child
            if (i < input.length && !input[i].equals("-1")) {
                curr.right = new Node(Integer.parseInt(input[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    // Main function to test the boundary traversal
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input (level order)
        String[] input = br.readLine().trim().split("\\s+");

        // Build the tree
        Node root = buildTree(input);

        // Perform boundary traversal
        List<Integer> result = boundaryTraversal(root);

        // Print the result
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
