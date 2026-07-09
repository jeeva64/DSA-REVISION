class Solution {
    public int equalPairs(int[][] grids) {
        int n = grids.length;
        int result = 0;

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < grids[row].length; col++) {
                boolean isValid = true;

                for(int k = 0; k < n; k++) {
                    if(grids[row][k] != grids[k][col]) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid)
                    result++;
            }
        }
        return result;
    }
}