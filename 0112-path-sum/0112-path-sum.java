/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return Traversal(root, targetSum);
    }
    private boolean Traversal(TreeNode node, int targetSum) {
        if(node == null)    return false;
        if(node.left == null && node.right == null)        return targetSum == node.val;

        boolean leftSum = Traversal(node.left, targetSum - node.val);
        boolean rightSum = Traversal(node.right, targetSum - node.val);

        return leftSum || rightSum;
    }
}