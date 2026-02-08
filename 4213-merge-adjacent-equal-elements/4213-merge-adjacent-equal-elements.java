class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> arr = new ArrayList<>();
    
        for(int num : nums) {
            long cur = num;
            while(!arr.isEmpty() && arr.get(arr.size()-1) == cur) {
                cur += arr.remove(arr.size()-1);
            } 
            arr.add(cur);
        }
        return arr;
    }
}