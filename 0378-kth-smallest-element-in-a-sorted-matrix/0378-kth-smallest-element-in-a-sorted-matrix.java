class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], rows = matrix.length, cols = matrix[0].length;
        int right = matrix[rows-1][cols-1];

        while(left < right){
            int mid = left + (right - left) / 2;
            // Count how many elements in the matrix are <= mid
            int count = countNum(matrix, mid, rows, cols);

            // If there are fewer than k elements < mid,
            // the k-th smallest must be larger than mid
            if(count < k){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
    private int countNum(int[][] matrix, int x, int rows, int cols){
        int count = 0, col = cols - 1;
        for(int row = 0; row < rows; row++){
            // Move left while the current element is greater than x
            while(col >= 0 && matrix[row][col] > x){
                col--;
            }
            count += col + 1;
        }
        return count;
    }
}