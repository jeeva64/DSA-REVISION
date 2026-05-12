class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maximum = Integer.MIN_VALUE;
        List<Boolean> result = new ArrayList<>();

        //Step 1: Finds Maximum number in the candies
        for(int num : candies)
            maximum = Math.max(maximum, num);

       
        //Step 2: Compute result by comparing with extraCandies sum
        for(int num : candies) {
            if((num + extraCandies) >= maximum)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}