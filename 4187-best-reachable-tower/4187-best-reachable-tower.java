class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int[] result = new int[]{-1, -1};
        int maxQF = -1;
        
        for(int[] tower : towers) {
            int xi = tower[0], yi = tower[1], xj = center[0], yj = center[1];
            int qf = tower[2];
        
            int manhattanDist = Math.abs(xi - xj) + Math.abs(yi - yj);
            int resX = result[0], resY = result[1];
            boolean islexco = (resX == -1) || (xi < resX) || (xi == resX && yi < resY);
            if(manhattanDist <= radius) {
                if(qf > maxQF || (qf == maxQF && islexco)) {
                    maxQF = qf;
                    result[0] = xi;
                    result[1] = yi;
                }
            }
        }
        return result;
    }
}