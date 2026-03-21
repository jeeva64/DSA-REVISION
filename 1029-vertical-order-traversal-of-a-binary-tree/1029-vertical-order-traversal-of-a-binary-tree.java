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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //HD Distance as key 
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        verticalTraversal(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for(List<int[]> list : map.values()) {
            //DUE TO: multiple nodes in the same row and same column
            Collections.sort(list, (a, b) -> {
                if(a[0] == b[0])
                    return a[1] - b[1];     //sort by values
                return a[0] - b[0];         //sort by rows
            });

            List<Integer> col = new ArrayList<>();
            for(int[] arr : list) 
                col.add(arr[1]);
            
            result.add(col);
        }
        return result;
    }
    private void verticalTraversal(TreeNode root, int row, int hd, Map<Integer, List<int[]>> map){
        if(root == null) return;
        
        map.computeIfAbsent(hd, k -> new ArrayList<>()).add(new int[]{row, root.val});
        verticalTraversal(root.left, row+1, hd-1, map);
        verticalTraversal(root.right, row+1, hd+1, map);
    }
}