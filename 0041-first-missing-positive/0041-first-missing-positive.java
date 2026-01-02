class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;

        while(i < n) {
            //Cyclic Sort Condition
            int validIdx = nums[i] - 1;

            //EDGE CASE: Nums has -ve value & some missing numbers in n
            if(nums[i] > 0 && nums[i] < n && nums[i] != nums[validIdx]) {
                int temp = nums[i];
                nums[i] = nums[validIdx];
                nums[validIdx] = temp;
            } else {
                i++;
            }
        }

        for(i = 0; i < n; i++) {
            if(nums[i] != i+1) return i+1;
        }

        return n+1;
    }
}