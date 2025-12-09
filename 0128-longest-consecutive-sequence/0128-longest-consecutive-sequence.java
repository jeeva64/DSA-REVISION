class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0, count = 0;

        //Popoluate the set with nums
        for(int num : nums)     set.add(num);

        //iterate over set
        for(int num : set){
            //Resets count for newer consecitive sequence length
            count = 0;
            //check by substracting num-1 in set 
            if(!set.contains(num-1)){
                //If num-1 is not there then, count them & check for consecutives
                while(set.contains(num)){
                    num++;
                    count++;
                }
                // longest > currentCount ? longest : currentCount;
                longest = Math.max(longest, count);
            }
            
        }
        return longest;
    }
}