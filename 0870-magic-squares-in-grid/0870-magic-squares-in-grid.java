class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length, cols = grid[0].length;

        //here rows-3 or cols-3 for splitting 3*3 submatrix
        for(int i = 0; i <= rows-3; i++){
            for(int j = 0; j <= cols-3; j++){
                if(isMagicSquare(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isMagicSquare(int[][] grid, int rowStart, int colStart){
        //CASE 1, 3*3 submatrix contains only unique numbers
        boolean[] visited = new boolean[10];

        //CASE 2, 3*3 submatrix contains number between 1 to 9
        for(int i = rowStart; i < rowStart+3; i++){
            for(int j = colStart; j < colStart+3; j++){
                int val = grid[i][j];
                if(val < 1 || val > 9 || visited[val]){
                    return false;
                }
                visited[val] = true;
            }
        }

        //CASE 3, all rows, cols, diagonal sum are EQUAL
        int Sum = grid[rowStart][colStart] + grid[rowStart][colStart+1] + grid[rowStart][colStart+2];
        for(int i = rowStart; i < rowStart+3; i++){
            int rowSum = grid[i][colStart] + grid[i][colStart+1] + grid[i][colStart+2];
            if(rowSum != Sum)       return false;
        }

        for(int i = colStart; i < colStart+3; i++){
            int colSum = grid[rowStart][i] + grid[rowStart+1][i] + grid[rowStart+2][i];
            if(colSum != Sum)       return false;
        }
        
        int primaryDiagonalSum = grid[rowStart][colStart] + grid[rowStart+1][colStart+1] + grid[rowStart+2][colStart+2];
        int secondaryDiagonalSum = grid[rowStart][colStart+2] + grid[rowStart+1][colStart+1] + grid[rowStart+2][colStart];

        return (Sum == primaryDiagonalSum && primaryDiagonalSum == secondaryDiagonalSum) ? true : false;
    }
}