package src.main.java.topicwise.binary.trees;

public class PathSum {

    public static void main(String[] args) {
        hasPathSum(new TreeNode(), 22);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasSum(root, targetSum, 0);
    }

    public static boolean hasSum(TreeNode root, int targetSum, int currSum) {
        if (root == null) {
            return false;
        }
        currSum = root.val + currSum;
        if (currSum == targetSum && root.left == null && root.right == null) {
            return true;
        }
        boolean left = hasSum(root.left, targetSum, currSum);
        boolean right = hasSum(root.right, targetSum, currSum);
        return left || right;
    }
}
