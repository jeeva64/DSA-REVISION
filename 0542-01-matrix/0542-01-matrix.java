class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;         //Row
        int m = mat[0].length;      //Column

        int dist[][] = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        //Step 1: Initialize distance with 0 & max for 1
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    dist[i][j] = Integer.MAX_VALUE;
            }
        }

        //Directions for BFS: Top, Right, Down, Left
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        //BFS
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            for(int d = 0; d < 4; d++) {
                int newRow = row + dx[d];
                int newCol = col + dy[d];

                //Boundary Condition on expanded on bfs
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newDist = dist[row][col] + 1;

                    //Updates only minimum distance affected by 0
                    if(newDist < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newDist;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return dist;
    }
}