class Solution {
    public String largestNumber(int[] nums) {
        String[] strNum = new String[nums.length];

        //Transform int array to String array
        for(int i = 0; i < nums.length; i++) 
            strNum[i] = String.valueOf(nums[i]);

        //Custom Comparator with Bubble or Selection Sorting methodology
        Arrays.sort(strNum, new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;  
                //Swaps if order2 is largest number
                //Else not swaps
                return order2.compareTo(order1); 
            }
        });

        //Edge Case
        if(strNum[0].equals("0"))   return "0";

        //Computes String result from array
        StringBuilder sb = new StringBuilder();
        for(String num : strNum)
            sb.append(num);

        return sb.toString();
    }
}