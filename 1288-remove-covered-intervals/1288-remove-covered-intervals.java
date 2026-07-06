class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
            a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
        );
        int result = intervals.length;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int curEnd = intervals[i][1];
            if(curEnd <= prevEnd)
                result--;
            else 
                prevEnd = curEnd;
        }

        return result;
    }
}