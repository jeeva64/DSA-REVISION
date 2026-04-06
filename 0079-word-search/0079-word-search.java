class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;           //Row
        int n = board[0].length;       //Column

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //Calls DFS: Only when cur char is equal to word first letter
                if(board[i][j] == word.charAt(0) && DFS(board, word, i, j, 0)) 
                    return true;
            }
        }
        return false;
    }
    //Multi-source DFS
    private boolean DFS(char[][] board, String word, int row, int col, int idx) {
        //BASE CASE: Recursion 
        //When we reach last character of the word
        if(word.length() == idx)    return true;

        //Invalid Boundaries in the Four Direction DFS and Problem Specific Constraints: 
            //1. Prune, If Already Visited character by 0 representation
            //2. Prune, If board current character != word current character
        if(row < 0 || col < 0 || row >= board.length || col >=  board[0].length || board[row][col] == '0' || board[row][col] != word.charAt(idx))
            return false;

        //Stores cur character used in Backtracking for UNDO of Invalid Operations
        char temp = board[row][col];
        //Marks, Visisted to avoid repeated search
        board[row][col] = '0';

        //Top -> Right -> Down -> Left
        if( DFS(board, word, row-1, col, idx+1) ||
            DFS(board, word, row, col+1, idx+1) ||
            DFS(board, word, row+1, col, idx+1) ||
            DFS(board, word, row, col-1, idx+1)  )
            return true;

        //Back Tracks character
        board[row][col] = temp;
        return false;    
    }
}