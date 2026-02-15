class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> result = new ArrayList<>();
        int[] toggle = new int[101];
        
        for(int i = 1, j = 0; i <= 100 && j < bulbs.size(); i++) {
            int bulb = bulbs.get(j++);
            if(toggle[bulb] == 0) {
                toggle[bulb] = 1; 
            } 
            else {
                toggle[bulb] = 0;    
            }
        }

        for(int i = 1; i <= 100; i++) {
            if(toggle[i] != 0)
                result.add(i);
        }
        result.sort(Comparator.naturalOrder());
        return (!result.isEmpty()) ? result : new ArrayList<>();
    }
}