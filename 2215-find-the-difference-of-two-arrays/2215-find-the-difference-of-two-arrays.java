class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        //Populate the two set with nums1 & nums 2 elements
        for(int i = 0; i < nums1.length; i++) 
            set1.add(nums1[i]);
        for(int i = 0; i < nums2.length; i++) 
            set2.add(nums2[i]);
        

        List<List<Integer>> result = new ArrayList<>(2);
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        //Check the problem condition for result arraylist
        for(int val : set1) {
            if(!set2.contains(val))
                result.get(0).add(val);
        }
        for(int val : set2) {
            if(!set1.contains(val))
                result.get(1).add(val);
        }
        return result;
    }
}