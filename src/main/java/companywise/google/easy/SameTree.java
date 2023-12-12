package src.main.java.companywise.google.easy;

import src.main.java.topicwise.binary.trees.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null)
                || (p != null && q == null)
                || (p.val != q.val)) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
