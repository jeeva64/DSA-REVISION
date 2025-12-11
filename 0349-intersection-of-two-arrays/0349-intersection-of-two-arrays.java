class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Stores nums1 unique elements 
        Set<Integer> map = new HashSet<>();
        //Stores if map elements in nums2
        Set<Integer> result = new HashSet<>();

        //populate nums1 in set
        for(int num : nums1){
            map.add(num);
        }

        //Checks set val in nums2 to add on results
        for(int num : nums2){
            if(map.contains(num)){
                result.add(num);
            }
        }

        //stores & return as array
        int i = 0;
        int[] arrRes = new int[result.size()];
        for(int num : result){
            arrRes[i++] = num;
        }
        return arrRes;
    }
}