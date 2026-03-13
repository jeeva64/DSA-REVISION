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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         //BFS ALGORITHM
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)    return result;
        
        //ZIG ZAG TOGGLER
        boolean leftToRight = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                //ADDS: Next level nodes to queue for BFS
                if(cur.left != null)    queue.offer(cur.left);
                if(cur.right != null)   queue.offer(cur.right);

                if(leftToRight)
                    temp.add(cur.val);
                else 
                    //Similiar reversing list based on even level nodes
                    temp.add(0, cur.val);
            }
            leftToRight = !leftToRight;
            result.add(temp);
        }
        return result;
    }
}
