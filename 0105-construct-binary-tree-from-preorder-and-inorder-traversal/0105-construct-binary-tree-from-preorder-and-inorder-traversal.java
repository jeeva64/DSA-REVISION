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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Hash map for inorder with its indexes as value & nums as key
        Map<Integer, Integer> inMap = new HashMap<>();
        TreeNode root = null;

        //Populate map with num & index
        for(int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
            
        root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inMap);
        return root;
    }
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        
        if(preEnd < preStart || inEnd < inStart)    return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);
        int numsLeftLength = inIndex - inStart;

        root.left = buildTree(preorder, preStart+1, preEnd+numsLeftLength, inorder, inStart, inIndex-1, inMap);
        root.right = buildTree(preorder, preStart+numsLeftLength+1, preEnd, inorder, inIndex+1, inEnd, inMap);

        return root;
    }
}