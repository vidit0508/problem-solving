package src.main.java.topicwise.binary.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        largestValues(root);
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            queue.add(null);
            int max = Integer.MIN_VALUE;
            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                if (node != null) {
                    max = Math.max(max, node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            queue.poll();
            list.add(max);
        }
        return list;
    }
}
