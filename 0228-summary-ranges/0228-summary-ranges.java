class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;
        if(n == 0)      return result;

        //Two Pointers Approach
        int left = 0;
        while(left < n) {
            int right = left;
            int start = nums[left];

            //Skips the valid continuous range in ascending
            while(right + 1 < n && nums[right+1] == nums[right] + 1)
                right++;

            //Edge case for single & same range
            if(start == nums[right])
                result.add(String.valueOf(start));

            //Adds valid range with -> symbol    
            else
                result.add(start + "->" + nums[right]);

            //Moves left after each valid range insert
            left = right + 1;
        }
        return result;
    }
}