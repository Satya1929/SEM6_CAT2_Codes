import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class vertical_order_traversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] nodes = input.split(" ");

        if (nodes[0].equals("N")) return;

        // Build the tree
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (!nodes[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }

        // Perform vertical order traversal
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> traversalQueue = new LinkedList<>();
        traversalQueue.add(new Pair(root, 0));

        while (!traversalQueue.isEmpty()) {
            Pair p = traversalQueue.poll();
            TreeNode node = p.node;
            int vertical = p.position;

            map.computeIfAbsent(vertical, k -> new ArrayList<>()).add(node.val);

            if (node.left != null) traversalQueue.add(new Pair(node.left, vertical - 1));
            if (node.right != null) traversalQueue.add(new Pair(node.right, vertical + 1));
        }

        // Print the result
        for (List<Integer> list : map.values()) {
            for (int value : list) {
                System.out.print(value + " ");
            }
        }
    }

    public static class Pair {
        TreeNode node;
        int position;

        Pair(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }
}
