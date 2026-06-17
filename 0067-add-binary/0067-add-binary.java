class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while(i >= 0 || j >= 0 || carry == 1) {
            //Gets LSB from a
            if(i >= 0)
                carry += a.charAt(i--) - '0';

            //Gets LSB from b
            if(j >= 0)
                carry += b.charAt(j--) - '0';

            //Appends both lsb sum remainder
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }
}