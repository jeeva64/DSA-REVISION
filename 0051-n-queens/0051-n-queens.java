class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) 
            Arrays.fill(board[i], '.');

        backTrack(0, board, result, n);
        return result;
    }
    private void backTrack(int col, char[][] board, List<List<String>> result, int n) {
        if(col == n) {
            //METHOD: Converts char matrix to ArrayList with each row as one val
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                //PRUNING: Skip to next Column,after one Q is placed at one column
                backTrack(col+1, board, result, n);

                //BACTRACKS: If not Valid N Queen
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col, int n) {
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 'Q')
                return false;
        }

        //Upper Left Diagonal Attack Detection with Optimization
        for(int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if(board[row-i][col-i] == 'Q')
                return false;
        }

        //Lower Left Diagonal Attack Detection with Optimization
        for(int i = 1; row + i < n && col - i >= 0; i++) {
            if(board[row+i][col-i] == 'Q')
                return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for(char[] row : board) 
            res.add(new String(row));
        
        return res;
    }
}