package src.main.java.topicwise.binary.trees;


// check this
public class FlattenBinaryTreeToLinkedList {

    static TreeNode res = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);
    }

    public static void flatten(TreeNode root) {
        doFlatten(root);
        root = res;
    }

    public static void doFlatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode node = new TreeNode(root.val);
        if (res == null) {
            res = node;
        } else {
            TreeNode last = res;
            while (last.right != null) {
                last = last.right;
            }
            last.right = node;
        }
        doFlatten(root.left);
        doFlatten(root.right);
    }
}
