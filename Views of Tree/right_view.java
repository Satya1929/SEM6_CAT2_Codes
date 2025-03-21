public class Right_view {
    
}

//leetcode
// Function to get the right view of the binary tree
public static void rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(root, 0, ans);
    
    // Print the result
    for (int val : ans) {
        System.out.print(val + " ");
    }
}

// Recursive helper function to traverse the tree and capture the right view
public static void helper(TreeNode node, int level, List<Integer> ans) {
    if (node == null) return;

    // If this is the first time we're visiting this level, add the node's value
    if (ans.size() == level) {
        ans.add(node.val);
    }

    // Traverse the right subtree first, then the left subtree
    helper(node.right, level + 1, ans);
    helper(node.left, level + 1, ans);
}




// hackerank
// import java.io.*;
// import java.util.*;


class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Solution {

    // Function to get the right view of the binary tree
    public static void rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        
        // Print the result
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    // Recursive helper function to traverse the tree and capture the right view
    public static void helper(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;

        // If this is the first time we're visiting this level, add the node's value
        if (ans.size() == level) {
            ans.add(node.val);
        }

        // Traverse the right subtree first, then the left subtree
        helper(node.right, level + 1, ans);
        helper(node.left, level + 1, ans);
    }

    // Function to build the binary tree from level-order input
    public static TreeNode buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < input.length) {
            TreeNode curr = queue.poll();
            
            // Left child
            if (i < input.length && !input[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(input[i]));
                queue.add(curr.left);
            }
            i++;

            // Right child
            if (i < input.length && !input[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(input[i]));
                queue.add(curr.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input
        String[] input = br.readLine().trim().split("\\s+");

        // Build the tree from input
        TreeNode root = buildTree(input);

        // Print the right side view of the tree
        rightSideView(root);
    }
}
