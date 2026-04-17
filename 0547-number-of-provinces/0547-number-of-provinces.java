class Solution {
    //Given isConnected is Adjacency Matrix
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;             //Row
        int count = 0;                          //Result
        boolean[] visited = new boolean[n];     //Visited array for Prune

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                visited[i] = true;
                //Calls only with beginning node of the component 
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }
    //DFS to search for Connected components & breaks by end of it
    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        for(int j = 0; j < isConnected[i].length; j++) 
        {
            if(!visited[j] && isConnected[i][j] != 0) {
                visited[j] = true;
                //Calls with j for indirectly connected nodes
                dfs(isConnected, j, visited);
            }
        }
    }
}