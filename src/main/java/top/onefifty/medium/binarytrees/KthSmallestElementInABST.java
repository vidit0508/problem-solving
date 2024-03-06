package src.main.java.top.onefifty.medium.binarytrees;

import src.main.java.topicwise.binary.trees.TreeNode;

import java.util.ArrayList;

public class KthSmallestElementInABST {

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = inorder(root, new ArrayList<Integer>());
        return list.get(k - 1);
    }
}
