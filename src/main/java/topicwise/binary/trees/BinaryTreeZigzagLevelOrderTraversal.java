package src.main.java.topicwise.binary.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        zigzagLevelOrder(new TreeNode());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> list = res.get(i);
                int start = 0;
                int end = list.size() - 1;

                while (start <= end) {
                    Integer temp = list.get(start);
                    list.set(start, list.get(end));
                    list.set(end, temp);
                    start++;
                    end--;
                }
                res.set(i, list);
            }
        }

        return res;
    }
}
