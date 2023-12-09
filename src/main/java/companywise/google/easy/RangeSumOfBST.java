package src.main.java.companywise.google.easy;

import src.main.java.topicwise.binary.trees.TreeNode;

public class RangeSumOfBST {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        getSum(root, low, high);
        return sum;
    }

    private void getSum(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            sum = sum + root.val;
        }

        if (low < root.val) {
            getSum(root.left, low, high);
        }

        if (high > root.val) {
            getSum(root.right, low, high);
        }
    }

}
