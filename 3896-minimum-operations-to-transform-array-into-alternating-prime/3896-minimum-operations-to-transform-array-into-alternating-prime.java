class Solution {
    static TreeSet<Integer> prime;
    static{
        int limit = 100010;
        prime = new TreeSet<>();
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        
        for(int i = 2; i < limit; i++){
            if(isPrime[i]){
                prime.add(i);
                for(int j = i+i; j < limit; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }
    public int minOperations(int[] nums) {
        int ans = 0;
        int N = nums.length;
        for(int i = 0; i < N; i++){
            if(i % 2 == 0){
                if(!prime.contains(nums[i])){
                    int next = prime.ceiling(nums[i]);
                    ans += next - nums[i];
                }
            }else{
                if(prime.contains(nums[i])){
                    ans++;
                    if(nums[i] == 2)ans++;
                }
            }
        }
        return ans;
    }
}