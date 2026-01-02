class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        //here n will 2 times of nums length
        int n = (nums.length) / 2, result = 0;

        //Populate nums element with frequency
        for(int i = 0; i < nums.length; i++) {
            int cnt = freq.getOrDefault(nums[i], 0);
            freq.put(nums[i], cnt+1);
        }
        
        //Iterate map & check freq == n then nums[i] is result
        for(Map.Entry<Integer, Integer> pair : freq.entrySet()) {
            int key = pair.getKey();
            int val = pair.getValue();
            if(val == n) {
                result = key; 
            }
        }
        return result;
    }
}