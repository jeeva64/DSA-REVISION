class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();     //Stores result [][]

        for(int[] interval : intervals){
            // Case 1: finds newInterval position & adds it & next interval will be newInterval
            if(newInterval[1] < interval[0]){
                result.add(newInterval);
                newInterval = interval;
            }
            // Case 2 : for previous non overlapping intervals added to result
            else if(interval[1] < newInterval[0]){
                result.add(interval);
            }
            // Case 3 : Handles the overlapping interval with min start & max end
            else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}