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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, long lowerBound, long upperBound) {
        //BASE CASE: Recursion
        if(root == null)    return true;

        //INVALID CONDITION
        if(root.val <= lowerBound || root.val >= upperBound)    return false;

        //COMPUTE: Its left & right subtree recursively
        boolean left = isBST(root.left, lowerBound, root.val);
        boolean right = isBST(root.right, root.val, upperBound);
    
        return left && right;
    }
}