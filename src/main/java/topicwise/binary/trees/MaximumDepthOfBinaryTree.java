package src.main.java.topicwise.binary.trees;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        maxDepth(new TreeNode());
    }

    public static int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.right), getHeight(root.left));
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.right), getHeight(node.left));
    }
}
