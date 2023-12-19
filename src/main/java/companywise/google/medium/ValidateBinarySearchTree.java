package src.main.java.companywise.google.medium;

import src.main.java.topicwise.binary.trees.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if ((min != null && min >= root.val)
                || (max != null && max <= root.val)) {
            return false;
        }

        return isValid(root.left, min, root.val)
                && isValid(root.right, root.val, max);
    }
}
