/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

//Binary Search
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0, right = n;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int status = guess(mid);

            //num == pick
            if(status == 0)
                return mid;

            //num > pick
            else if(status == -1)
                right = mid - 1;

            //num < pick
            else if(status == 1)
                left = mid + 1;
        }
        return -1;
    }
}