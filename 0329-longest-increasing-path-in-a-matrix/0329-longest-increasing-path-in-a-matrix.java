class Solution {
    //TOP -> RIGHT -> DOWN -> LEFT
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        //Edge Case
        if(matrix == null || matrix.length == 0)    return 0;

        int m = matrix.length;      //Row
        int n = matrix[0].length;   //Column
        int longestPath = 0;        //Result
        int[][] cacheDP = new int[m][n];    //For Memoization

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                int longest = dfs(matrix, cacheDP, m, n, i, j);
                longestPath = Math.max(longestPath, longest);
            }
        }
        return longestPath;
    }
    //DP With Memoization for DFS
    private int dfs(int[][] matrix, int[][] cache, int rowLen, int colLen, int row, int col) {
        //Return Pre-Computed Increasing Path
        if(cache[row][col] > 0)     return cache[row][col];
        int max = 0;

        //Expands: Neighnouring Depth in Four Directions
        for(int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            //Strictly Increasing
            if( newRow >= 0 && newCol >= 0 && newRow < rowLen && 
                newCol < colLen && matrix[newRow][newCol] > matrix[row][col] ) { 
                int len = dfs(matrix, cache, rowLen, colLen, newRow, newCol);
                max = Math.max(max, len);
            }
        }
        cache[row][col] = max + 1;

        return cache[row][col];
    }
}