class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxIce = 0;
        int iceCost = 0;
        //Sorts for maximum number of icecream with smaller cost
        Arrays.sort(costs);

        for(int cost : costs) {
            //Buys each icecream by its cost
            //and track the coins limit 
            if(iceCost + cost <= coins) {
                iceCost += cost;
                maxIce++;
            }
        }

        return maxIce;
    }
}