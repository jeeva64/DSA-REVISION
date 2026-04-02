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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convertBST(nums, 0, nums.length-1);
    }
    private TreeNode convertBST(int[] nums, int left, int right) {
        if(left > right)    return null;

        //Find Middle element for BST Conditions
        int mid = left + (right - left) / 2;
        TreeNode result = new TreeNode(nums[mid]);

        //Divide & Conquer
        result.left = convertBST(nums, left, mid-1);
        result.right = convertBST(nums, mid+1, right);

        return result;
    }
}