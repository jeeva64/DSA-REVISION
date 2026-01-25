class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int suffixLen = 0;
        int right = n-1;
        
        while(right >= 0) {
            int leftIdx = right-1;
            if(leftIdx >=0 && nums[leftIdx] < nums[right])
                suffixLen++;
            else
                break;
            right--;
        }
        return n-(suffixLen+1);
    }
}