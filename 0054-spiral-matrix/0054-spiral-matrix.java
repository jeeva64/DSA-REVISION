class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix[0].length, n = matrix.length, dir = 0;       //Confusion of M & N

        //Four Pointer Approach
        int left = 0, top = 0;
        int right = m-1, bottom = n-1;
        while(left <= right && top <= bottom){
            switch(dir){
                //left to right
                case 0 -> {
                    for(int i = left; i <= right; i++){
                        result.add(matrix[top][i]);
                    }
                    top++;
                }

                //top to bottom
                case 1 -> {
                    for(int i = top; i <= bottom; i++){
                        result.add(matrix[i][right]);
                    }
                    right--;
                }

                //right to left
                case 2 -> {
                    for(int i = right; i >= left; i--){
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                } 

                //bottom to top
                case 3 -> {
                    for(int i = bottom; i >= top; i--){
                        result.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            dir = (dir+1) % 4;
        }
        return result;
    }
}