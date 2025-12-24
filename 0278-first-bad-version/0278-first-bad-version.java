/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //Modified Binary Search
        int low = 1, high = n;

        while(low < high){                  //Equal is not used in this case
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid)){          //API Method for finding bad version
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        //First occurence type of binary search
        return low;
    }
}