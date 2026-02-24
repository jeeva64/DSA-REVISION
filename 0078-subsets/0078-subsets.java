class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        //start backtracking from position 0
        backTrack(res, nums, 0, new ArrayList<>());
        return res;
    }
    private void backTrack(List<List<Integer>> res, int[] nums, int pos, List<Integer> temp) {
        //adds all valid subsets
        res.add(new ArrayList(temp));

        for(int i = pos; i < nums.length; i++) {
            //Pick num 
            temp.add(nums[i]);
            //proceed to next position num
            backTrack(res, nums, i+1, temp);
            //backtrack for other subset
            temp.remove(temp.size()-1);
        }
    }
}