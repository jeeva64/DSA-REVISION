class Solution {
    public long minCost(String s, int[] cost) {
        long minCost = Long.MAX_VALUE, totalCost = 0;
        Map<Character, Long> str = new HashMap<>();
        
        for(int i = 0; i < cost.length; i++)
            totalCost += cost[i];            //compute total delete cost

        //Populate frequency of string s with cost[i] as its value
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            str.put(ch, str.getOrDefault(ch, 0L) + cost[i]);
        }

        //check min(totalCost - cost of s's charatcer in map)
        for(long freq : str.values())
            minCost = Math.min(minCost, totalCost - freq);
        return minCost;
    }
}