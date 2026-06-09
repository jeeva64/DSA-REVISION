class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> nums = new ArrayList<>();

        for(int num : arr) 
            map.put(num, map.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer, Integer> pairs : map.entrySet()) {
            int value = pairs.getValue();
            if(nums.contains(value))    return false;
    
            nums.add(value);
        }
        return true;
    }
}