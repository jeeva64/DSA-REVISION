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
    public int widthOfBinaryTree(TreeNode root) {
        //Stores Pair ds with Nodes as key, its indexes on array representation as value
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        int maxWidth = 0;

        //BFS with pair ds in queue. Instead TreeNode
        while(!queue.isEmpty()) {
            //EXPAND: Its next level nodes to queue as pair ds
            int size = queue.size();
            
            //Polls Pair and gets its value which is index
            int startIdx = queue.peek().getValue();
            //TRICK: For Geting last node of the current level as type casting to linkedlist
            int endIdx = ((LinkedList<Pair<TreeNode, Integer>>) queue).getLast().getValue();
            
            //COMPUTE RESULT
            int curWidth = endIdx - startIdx + 1;
            maxWidth = Math.max(maxWidth, curWidth);

            for(int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> cur = queue.poll();
                TreeNode curNode = cur.getKey();
                int Idx = cur.getValue();

                //Based on Array Representation of tree, we find its index
                if(curNode.left != null) {
                    //LEFT: 2*i+1, due to zero based index. so skip +1
                    queue.offer(new Pair<>(curNode.left, Idx * 2));
                }
                if(curNode.right != null) {
                    //RIGHT: 2*i+2, due to zero based index. so skip +2 and use +1
                    queue.offer(new Pair<>(curNode.right, Idx * 2 + 1));
                }
            }
        }
        return maxWidth;
    }
}