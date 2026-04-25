class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefixProd = 1;
        int suffixProd = 1;
        int maxProduct = nums[0];

        for(int i = 0; i < n; i++) {
            //Prefix Product
            prefixProd = (prefixProd == 0 ? 1 : prefixProd) * nums[i];
            //Suffix Product
            suffixProd = (suffixProd == 0 ? 1 : suffixProd) * nums[n - i - 1];
            //Maximim subarray product
            maxProduct = Math.max(maxProduct, Math.max(prefixProd, suffixProd));
        }
        return maxProduct;
    }
}