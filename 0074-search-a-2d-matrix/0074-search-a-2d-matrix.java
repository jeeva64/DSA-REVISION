class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        //Virtually Flatten matrix into array as an Intuition
        int low = 0, high = (row * col) - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;            //Compute mid for central value
            //Get index of matrix from flatten array
            int midVal = matrix[mid / col][mid % col];      

            if(midVal == target){
                return true;
            }
            else if(midVal > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}