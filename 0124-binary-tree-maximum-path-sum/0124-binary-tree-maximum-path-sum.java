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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }
    private int pathSum(TreeNode root) {
        //BASE CASE: For Recursion
        if(root == null)    return 0;

        //Recursively call next nodes by POST ORDER DFS
        //IGNORES: Negative root values
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));

        //COMPUTE: Maximum Path sum seen so far
        max = Math.max(max, left + right + root.val);

        //DUE TO: A node can only appear in the sequence at most once.
        //SO: We return maximum among left or right, strictly anyone
        return root.val + Math.max(left, right);
    }
}