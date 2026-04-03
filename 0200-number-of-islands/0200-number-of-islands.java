class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;        //Row
        int n = grid[0].length;     //Column
        int islandCnt = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //Finds only land to visit its horizontal or verticals lands
                if(grid[i][j] == '1') {
                    islandCnt++;
                    visit(i, j, grid, m, n);
                }
            }
        }
        return islandCnt;
    }
    private void visit(int row, int col, char[][] grid, int m, int n) {
        //TOP -> RIGHT -> DOWN -> LEFT 
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == '1') {
            //UPDATE LANDS: For Differentiating visited lands 
            grid[row][col] = '#';

            //EXPANDS: Adjacent Neighbouring lands
            for(int d = 0; d < 4; d++)
                visit(row + dx[d], col + dy[d], grid, m, n);
        }
    }
}