/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        //Base Case For Recursion
        if(node == null)        return null;

        //Create new node to clone the graph
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        //DFS
        for(Node neighbor : node.neighbors) {
            //if node's neighbor list elements (as key) contains in map then
            //we directly add entire list to newNode as neighbors list
            if(map.containsKey(neighbor))
                newNode.neighbors.add(map.get(neighbor));

            //if not in map of neighbors list do recursion.
            else
                newNode.neighbors.add(cloneGraph(neighbor));         
        }       
        return newNode;
    }
}