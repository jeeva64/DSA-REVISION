class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            int curDiff = arr[i] - arr[i-1];
            if(curDiff < minDiff){
                result =new ArrayList<>();
                minDiff = curDiff;
            }
            if(curDiff == minDiff){
                result.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return result;
    }
}