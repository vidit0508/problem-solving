package src.main.java.companywise.google.medium;

import src.main.java.topicwise.binary.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {

    List<List<Integer>> ans;
    public List<List<Integer>> findLeaves(TreeNode root) {
        ans = new ArrayList<>();
        getHeight(root);
        return ans;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        // here first we will calculate the height
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // at the leaf node the currHeight will be equal to 0
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // first time when code reaches here will be for leaf node level
        // so at that time ans size is zero, so for all the leaf nodes we will get height as zero
        // and rest nodes will get added to respective indexes == to their height.
        if (ans.size() == currHeight) {
            ans.add(new ArrayList<>());
        }

        ans.get(currHeight).add(root.val);

        return currHeight;
    }
}
