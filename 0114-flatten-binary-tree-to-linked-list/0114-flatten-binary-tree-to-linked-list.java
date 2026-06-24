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
    public void flatten(TreeNode root) {
        if(root == null)    return;
        List<TreeNode> nodes = new ArrayList<>();
        preOrderTraversal(root, nodes);

        //Gets Preorder Result as right continuous tree == LinkedList
        for(int i = 0; i < nodes.size() - 1; i++) {
            TreeNode node = nodes.get(i);
            TreeNode nextNode = nodes.get(i + 1);

            node.left = null;
            node.right = nextNode;
        }

    }
    //Binary Tree Pre Order Traversal
    private void preOrderTraversal(TreeNode root, List<TreeNode> result) {
        if(root == null)    return;

        result.add(root);
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }
}