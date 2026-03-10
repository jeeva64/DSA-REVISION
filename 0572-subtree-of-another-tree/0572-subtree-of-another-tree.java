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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null)    return false;

        //VALID CONDITION AT THE FIRST
        if(isSame(root, subRoot))    return true;

        //FINDS: subRoot.val == root.val 
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);    
    }
    private static boolean isSame(TreeNode t1, TreeNode t2) {
        //BASE CASE
        if(t1 == null || t2 == null)    return t1 == t2;

        //INVALID CONDITION
        if(t1.val != t2.val)    return false;

        //EXPAND: Branches by recursion for same tree checking
        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }
}