class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            //Gets last digit 1 by 1
            int digit = x % 10;
            //Removes last digit 1 by 1
            x /= 10;

            //Boundary condition 
            if(rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10){
                return 0;
            }
            //For positional value
            rev = (rev * 10) + digit;
        }
        return rev;
    }
}