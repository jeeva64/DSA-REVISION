class Solution {
    public int singleNumber(int[] nums) {
         
        Map<Integer, Integer> map = new HashMap<>();

        //Populate nums with frequency
        for(int num : nums){
            //If first time 1, else freq++
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //Check freq with 1 
        for(int num : map.keySet()){
            if(map.get(num) == 1)
                return num;
        }
        return -1;
    }
}