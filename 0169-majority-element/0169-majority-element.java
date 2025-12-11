class Solution {
    public int majorityElement(int[] nums) {
        int current = 0, cnt = 0;

        for(int num : nums){
            if(cnt == 0)          current = num;     //reset current = num, when cnt == 0
            if(num == current)    cnt++;             //increase running frequency of num == current
            if(num != current)    cnt--;             //decrease running frequency of num != current
        }
        return current;
    }
}