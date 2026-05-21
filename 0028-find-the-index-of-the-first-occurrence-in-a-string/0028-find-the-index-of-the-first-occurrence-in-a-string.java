class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length(), n2 = needle.length();   

        //Two Pointer left = 0 of s1
        //and right = s2 len for substring method in the s1 string
        for(int left = 0, right = n2; right <= n1; left++, right++) {
            if(haystack.substring(left, right).equals(needle))
                return left;
        }
        return -1;
    }
}