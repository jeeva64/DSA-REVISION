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
    public int maxLevelSum(TreeNode root) {
        if (root == null)   return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;
        //Breadth First Search
        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //Adds all level values for finding max sum
                levelSum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                } 
            }
            //Computes maximum sum & its level
            if(levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }
            //Increments each level
            level++;
        }
        return maxLevel;
    }
}