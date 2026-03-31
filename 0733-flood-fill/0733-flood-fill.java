class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)      return image;

        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }
    private void dfs(int[][] image, int row, int col, int color, int initColor) {
        int m = image.length;
        int n = image[0].length;

        if(row >= 0 && row < m && col >= 0 && col < n && image[row][col] == initColor) {
            //Fills Colour
            image[row][col] = color;

            //Expands: Neighbouring nodes in four directions
            dfs(image, row-1, col, color, initColor);       //Top
            dfs(image, row, col+1, color, initColor);       //Right
            dfs(image, row+1, col, color, initColor);       //Down
            dfs(image, row, col-1, color, initColor);       //Left
        }
    }
}