class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;

        while(left < right) {
            int mid = left + (right - left) / 2;
            //can eat, move left sub array
            if(canEatWithInTime(piles, mid, h))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    private boolean canEatWithInTime(int piles[], int k, int h) {
        int hours = 0;

        for(int pile : piles) {
            //Hours for eating bananas on piles[i]
            int div = pile / k;
            hours += div;

            //for piles[i] fully eaten by koko
            if(pile % k != 0)   hours++;
        }
        //within h to escape from guards by koko
        return hours <= h;
    }
}