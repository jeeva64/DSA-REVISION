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
        if(node == null)    return null;                        //base case for recursion
        Node newNode = new Node(node.val);                      //clone first node only
        map.put(node, newNode);                                   

        for(Node neighbor : node.neighbors){
            if(map.containsKey(neighbor)){                  //if node's neighbors list element contains in map then
                newNode.neighbors.add(map.get(neighbor));   //we directly get those list and add to newNode as neighbors
            }else{
                newNode.neighbors.add(cloneGraph(neighbor));    //if not in map of neighbors list do recursion and backtrack it
            }
        }
        return newNode;
    }
}