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
    int result = 0;
    int count = 1;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root, k);
        return result;
    }
    //LEFT ROOT RIGHT Approach
    private void inorderTraversal(TreeNode root, int k) {
        //BASE CASE: Recursion
        if(root == null || count > k)    return;
        inorderTraversal(root.left, k);

        if(count == k)
            result = root.val;
        count++;

        inorderTraversal(root.right, k);
    }
}