package src.main.java.binary.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        levelOrder(new TreeNode());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (null != node) {
                    tempList.add(node.val);
                    if (node.left != null) {
                        tempQueue.add(node.left);
                    }
                    if (node.right != null) {
                        tempQueue.add(node.right);
                    }
                }
            }
            queue.addAll(tempQueue);
            res.add(tempList);
        }

        return res;
    }
}
