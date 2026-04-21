class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        if(n == 0 || intervals == null)     return res.toArray(new int[n][]);
        //Custom Comparator sort array based on the first starting intervals
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] cur : intervals) {
            //Finds maximum end interval to merge overlapping intervals
            if(cur[0] <= end) {
                end = Math.max(end, cur[1]);
            }
            //Gets valid intervals after merging & added to result
            else {
                res.add(new int[]{start, end});
                start = cur[0];
                end = cur[1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[0][]);
    }
}