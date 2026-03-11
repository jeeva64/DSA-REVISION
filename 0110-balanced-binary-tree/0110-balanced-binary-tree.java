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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1 ? true : false; 
    }
    private int height(TreeNode root) {
        //BASE CASE
        if(root == null)    return 0;

        int left = height(root.left);
        int right = height(root.right);

        //PRUNING: Subtree is skipped after one invalid subtree part
        if(left == -1 || right == -1)   return -1;
        
        //CONDITION: For non balanced tree (valid are -1, 0, 1 diff of subtree)
        if(Math.abs(left-right) > 1)    return -1;

        //FINDS: Maximum height of the tree
        return 1 + Math.max(left, right);
    } 
}