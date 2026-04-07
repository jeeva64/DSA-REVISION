//Opposite Analogy for finding maximum building in pacific & atlantic then compute the comman building
class Solution {
    //Global Variables for DFS
    int rows, cols;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        //LEFT & RIGHT Direction
        for(int row = 0; row < rows; row++) {
            DFS(heights, pacific, row, 0, heights[row][0]);
            DFS(heights, atlantic, row, cols-1, heights[row][cols-1]);
        }   

        //TOP & BOTTOM Direction
        for(int col = 0; col < cols; col++) {
            DFS(heights, pacific, 0, col, heights[0][col]);
            DFS(heights, atlantic, rows-1, col, heights[rows-1][col]);
        } 

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j])
                    result.add(List.of(i,j));
            }
        }
        return result;
    }
    //Four Directional DFS
    private void DFS(int[][] heights, boolean[][] visited, int row, int col, int previous) {
        if( row < 0 || col < 0 || row >= rows || col >= cols || 
            visited[row][col] || heights[row][col] < previous)
            return;

        visited[row][col] = true;
        for(int d = 0; d < 4; d++) {
            int newRow = row + dx[d];
            int newCol = col + dy[d];
            DFS(heights, visited, newRow, newCol, heights[row][col]);
        }
    }
}