class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int curValue = target - nums[i];
            if(map.containsKey(curValue)){
                return new int[]{map.get(curValue), i};
            } else{
                //number as key & index as value
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}