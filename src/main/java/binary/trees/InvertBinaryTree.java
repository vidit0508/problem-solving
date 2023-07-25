package src.main.java.binary.trees;

public class InvertBinaryTree {

    public static void main(String[] args) {
        invertTree(new TreeNode());
    }

    public static TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
