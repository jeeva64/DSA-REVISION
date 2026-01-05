class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long result = 0;
        int minusSignCount = 0, minNum = Integer.MAX_VALUE;

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                //Sum of all absolute in matrix
                result += Math.abs(matrix[row][col]);
                //finds minnimum absolute in matrix
                minNum = Math.min(minNum, Math.abs(matrix[row][col]));
                
                //Count negative numbers
                if(matrix[row][col] < 0) {
                    minusSignCount++;
                } 
            }
        }
        //for even sign gets multiplied to positive sum
        if(minusSignCount % 2 == 0) {
            return result;
        }
        return result - (2*minNum);
    }
}