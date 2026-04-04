class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0, time = 0;
        //For BFS
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //For Rotten Oranges
                if(grid[i][j] == 2)
                    //Multi-Source BFS. so we add all rotten oranges co-ordinates to the queue
                    queue.offer(new int[] {i, j, 0});
                
                //For Fresh Oranges
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        //TOP -> RIGHT -> DOWN -> LEFT
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        //BFS With Four directions
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0], col = cur[1], t = cur[2];
            time = Math.max(time, t);

            for(int d = 0; d < 4; d++) {
                int newRow = row + dx[d];
                int newCol = col + dy[d];

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    //Fresh Oranges rotten by the adjacent existing rotten orange
                    grid[newRow][newCol] = 2;
                    
                    //so, Fresh orange count decreses for computing result
                    freshOranges--;

                    //Adds, new Fresh Oranges co-ordinate to the queue for expansion. with time minute
                    queue.offer(new int[] {newRow, newCol, t + 1});
                }
            }
        }

        return freshOranges == 0 ? time : -1;
    }
}