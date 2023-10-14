package src.main.java.topicwise.binary.trees;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        isValidBST(new TreeNode());
    }

    public static boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isValid(root.left, null, root.val)
                && isValid(root.right, root.val, null);
    }

    private static boolean isValid(TreeNode node, Integer min, Integer max) {
        if (null == node) {
            return true;
        }

        if ((null != max && node.val >= max)
                || (null != min && node.val <= min)) {
            return false;
        }

        return isValid(node.left, min, node.val)
                && isValid(node.right, node.val, max);
    }

}
