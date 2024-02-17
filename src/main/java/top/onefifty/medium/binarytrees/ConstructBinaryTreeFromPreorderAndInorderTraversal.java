package src.main.java.top.onefifty.medium.binarytrees;

import src.main.java.topicwise.binary.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    static int preorderIndex;
    static Map<Integer, Integer> inorderMap;

    public static void main(String[] args) {

        // preorder = root -> left -> right
        int[] preorder = {3, 9, 20, 15, 7};

        // // preorder = left -> root -> right
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(preorder, inorder);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return createTree(preorder, 0, preorder.length - 1);
    }

    private static TreeNode createTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = createTree(preorder, left, inorderMap.get(rootValue) - 1);
        root.right = createTree(preorder, inorderMap.get(rootValue) + 1, right);

        return root;
    }

}
