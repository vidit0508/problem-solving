package src.main.java.binary.trees;

import com.sun.source.tree.Tree;

public class ConvertBinaryTreeFromPreorderAndInorderTraversal {

    static int p = 0;
    static int i = 0;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = build(preorder, inorder, Integer.MIN_VALUE);
    }

    private static TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }

        if (inorder[i] == stop) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }
}
