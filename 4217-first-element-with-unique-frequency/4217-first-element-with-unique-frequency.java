class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
    
        //nums freq
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        //FreqCount
        Map<Integer, Integer> freqCount = new HashMap<>();
        for(int f : freq.values()) {
           freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
        }

        //find unique freq
        for(int num : nums) {
            int f = freq.get(num);
            if(freqCount.get(f) == 1)
                return num;
        }
        return -1;
    }
}