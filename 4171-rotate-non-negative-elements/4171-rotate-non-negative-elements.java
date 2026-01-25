class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        //Gets Non-Negative Numbers
        for(int num : nums)
            if(num >= 0)
                list.add(num);

        int nonSize = list.size();
        if(nonSize == 0)    return nums;
        k %= nonSize;
    
        //Rotate Non-Negative Numbers
        reverse(list, 0, k-1);
        reverse(list, k, nonSize-1);
        reverse(list, 0, nonSize-1);

        //Replace nums
        int j = 0;
        for(int i = 0; i < n && j < nonSize; i++) {
            if(nums[i] >= 0)
                nums[i] = list.get(j++);
        }
        return nums;
    }
    private List reverse(List<Integer> nums, int left, int right) {
        while(left < right) {
            int temp = nums.get(right);
            nums.set(right, nums.get(left));
            nums.set(left, temp);
            left++;
            right--;
        }
        return nums;
    }
}