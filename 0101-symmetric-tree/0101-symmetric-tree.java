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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;

        return isSymmetric(root.left, root.right);
    }
    //SAME CODE: Same Tree Problem
    private boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null || rightTree == null)    return leftTree == rightTree;

        if(leftTree.val != rightTree.val)    return false;

        //ALTERNATIVE CALL: left & right (or) right & left as Symmetric
        return isSymmetric(leftTree.left, rightTree.right) && isSymmetric(leftTree.right, rightTree.left);
    }
}