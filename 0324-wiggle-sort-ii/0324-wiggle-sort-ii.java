class Solution {
    public void wiggleSort(int[] nums) {
        //Sort to get maximum & minumum numbers
        Arrays.sort(nums);
        //Two pointer approach 
        int n = nums.length, idx = 0;
        int mid = (n-1) / 2, right = n-1;
        int[] result = new int[n+1];

        while(mid >= 0 || right > (n-1) / 2){
            // if(idx % 2 == 0)
                result[idx++] = nums[mid--];
            // else
                result[idx++] = nums[right--]; 
        }

        //Alter nums by result
        for(int i = 0; i < n; i++){
            nums[i] = result[i];
            System.out.println(result[i]);
        }
    }
}