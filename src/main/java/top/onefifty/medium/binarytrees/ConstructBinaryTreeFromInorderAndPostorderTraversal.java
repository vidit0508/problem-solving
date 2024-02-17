package src.main.java.top.onefifty.medium.binarytrees;

import src.main.java.topicwise.binary.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    static int postIndex;
    static Map<Integer, Integer> inorderMap;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return createTree(postorder, 0, inorder.length - 1);
    }

    private static TreeNode createTree(int[] postorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int index = inorderMap.get(rootValue);

        root.right = createTree(postorder, index + 1, right);
        root.left = createTree(postorder, left, index - 1);

        return root;
    }
}
