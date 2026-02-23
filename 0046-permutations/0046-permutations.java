class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        //Backtracking
        backtrack(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] used, List<Integer> temp) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i] == true)    continue;

            used[i] = true;
            temp.add(nums[i]);
            backtrack(res, nums, used, temp);
            
            //Undo for Backtrack (remove in temp, mark not used as before)
            used[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}