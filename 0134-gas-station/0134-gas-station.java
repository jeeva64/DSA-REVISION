class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Computes total for pruning
        int gasTotal = 0, costTotal = 0;
        for(int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
        }
        //Prune Condition
        if(costTotal > gasTotal)        return -1;

        int curGas = 0, startIdx = 0;
        for(int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            //Skips Negative starting index & rests current gas 
            if(curGas < 0) {
                curGas = 0;
                startIdx = i + 1;
            }
        }
        return startIdx;
    }
}