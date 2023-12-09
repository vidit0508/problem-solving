package src.main.java.companywise.google.easy;

import src.main.java.topicwise.binary.trees.TreeNode;

public class IncreasingOrderSearchTree {

    TreeNode node = null;
    public TreeNode increasingBST(TreeNode root) {
        createBst(root);
        return node;
    }

    public void createBst(TreeNode root) {
        if (root == null) {
            return;
        }
        createBst(root.left);
        addNode(root.val);
        createBst(root.right);
    }

    private void addNode(int val) {
        if (node == null) {
            node = new TreeNode(val);
        } else {
            TreeNode last = node;
            while (last.right != null) {
                last = last.right;
            }
            last.right = new TreeNode(val);
        }
    }
}
