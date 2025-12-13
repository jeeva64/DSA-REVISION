class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        //Popolate Zeros Row & Column
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(matrix[row][col] == 0){
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        //Set those rows to 0
        for(int row : rows){
            for(int col = 0; col < n; col++){
                matrix[row][col] = 0;
            }
        }
        //Set those columns to 0
        for(int row = 0; row < m; row++){
            for(int col : cols){
                matrix[row][col] = 0;
            }
        }
    }
}