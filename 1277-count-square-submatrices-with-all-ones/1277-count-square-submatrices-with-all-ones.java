//DP With Tabulation Approach
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //Multi Dimensional DP
        int[][] dp = new int[rows+1][cols+1];
        int result = 0;

        for(int i = 1; i <= rows; i++)  {
            for(int j = 1; j <= cols; j++)  {
                if(matrix[i-1][j-1] == 1) {
                    //here 1 is for 1*1 submatrix as consideration
                    dp[i][j] = 1 +  Math.min(
                        dp[i-1][j],             //Above value in previous row
                        Math.min(
                            dp[i][j-1],         //Left value in same row
                            dp[i-1][j-1]        //Diagonal Value
                        )           
                    );
                    result += dp[i][j];
                }
            }
        }
        return result;
    }
}