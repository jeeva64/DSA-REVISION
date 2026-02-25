class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //Optimization
        Arrays.sort(candidates);

        backTrack(res, candidates, 0, target, new ArrayList<>());
        return res;
    }
    private void backTrack(List<List<Integer>> res, int[] nums, int pos, int target, List<Integer> temp) {
        if(target < 0)    return;
        if(target == 0) {
            res.add(new ArrayList<>(temp));
        }

        for(int i = pos; i < nums.length; i++) {
            //Optimization
            if(nums[i] > target)    return;

            temp.add(nums[i]);
            //pos is not incremented like other problems and target is decrement by current num
            backTrack(res, nums, i, target - nums[i], temp);

            //Backtracks to remove last inserted temp number in recursion
            temp.remove(temp.size()-1);
        }
    }
}