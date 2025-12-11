class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0, count = 0;
        //Map to store diff bw running sum & k
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i < n; i++){
            prefixSum += nums[i];
            int diff = prefixSum - k;                   //Intuitive Logic
            //diff in map,then count += freq of map
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            //Add new prefixSum to map, if already exist then freq++
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}