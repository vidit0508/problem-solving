package src.main.java.topicwise.binary.trees;

public class SymmetricTree {

    public static void main(String[] args) {
        isSymmetric(new TreeNode());
    }

    public static boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return validateTree(root.left, root.right);
    }

    private static boolean validateTree(TreeNode node1, TreeNode node2) {
        if (null == node1 && null == node2) {
            return true;
        }

        if ((null == node1 && null != node2)
                || (null != node1 && null == node2)
                || (node1.val != node2.val)) {
            return false;
        }

        return validateTree(node1.left, node2.right)
                && validateTree(node1.right, node2.left);
    }
}
