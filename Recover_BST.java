public class Recover_BST {
    
}

//leetcode

class Solution {//99. Recover Binary Search Tree
    //https://leetcode.com/problems/recover-binary-search-tree/submissions/1573319192/
    // Brute-force approach 
    private void inorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root);
        inorder(root.right, nodes);
    }
    
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        List<Integer> values = new ArrayList<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }

        Collections.sort(values);

        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).val = values.get(i);  // Reassign values in sorted order
        }
    }
}



class Solution {//99. Recover Binary Search Tree
    //https://leetcode.com/problems/recover-binary-search-tree/submissions/1573319192/
    //optimal
    private TreeNode first, prev, middle, last;

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && root.val < prev.val) {
            // If this is the first violation, mark 'first' and 'middle'
            if (first == null) {
                first = prev;
                middle = root;
            } 
            // If this is the second violation, mark 'last'
            else {
                last = root;
            }
        }

        // Mark current node as previous for next iteration
        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if (first != null && last != null) 
            swap(first, last);
        else if (first != null && middle != null) 
            swap(first, middle);
    }

    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}






// hackerrank (8/10 passed)
// import java.io.*; 
// import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; left = null; right = null; }
}

public class Solution {

    // Function to recover the BST by swapping only two incorrect nodes
    static void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        inorder(root, nodes);

        TreeNode first = null, second = null;

        // Find the two swapped nodes
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i).val > nodes.get(i + 1).val) {
                if (first == null) {
                    first = nodes.get(i);  // First incorrect node
                }
                second = nodes.get(i + 1);  // Second incorrect node
            }
        }

        // Swap the values of the two incorrect nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    // Inorder traversal to collect nodes
    static void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    // Function to build a binary tree from level-order input
    static TreeNode buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode curr = queue.poll();
            
            // Left child
            if (i < input.length && !input[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(input[i]));
                queue.add(curr.left);
            }
            i++;

            // Right child
            if (i < input.length && !input[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(input[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }

    // Print level-order traversal of tree (Correct Output Format)
    static void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input, ensuring proper handling of spaces
        String[] input = br.readLine().trim().split("\\s+");

        TreeNode root = buildTree(input);

        recoverTree(root);

        printLevelOrder(root);
    }
}
