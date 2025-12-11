//Problem is similiar to tackling the (subarray sum == 0) and assuming zero(0) as -1
//HashMap with Key as Prefix sum and Values as their respective index
class Solution {
    public int findMaxLength(int[] nums) {
        int pSum = 0, longest = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            pSum += (nums[i] == 0) ? -1 : 1;        //Our Derived Intuition statement
            
            if(pSum == 0){
                longest = i + 1;                    //Finded Length of the Equal number of 0,1 subarray 
            }
            else if(map.containsKey(pSum)){
                //Finds Maximum longest by Map's Index
                //Just Current index - starting index of equal number subarray
                longest = Math.max(longest, i - map.get(pSum));                 
            }
            else{
                map.put(pSum, i);                   //Populate prefix sum & their index i
            }
        }
        return longest;
    }
}