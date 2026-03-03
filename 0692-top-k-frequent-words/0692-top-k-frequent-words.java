class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //Populate Frequency of the words string array
        Map<String, Integer> freq = new HashMap<>();
        for(String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        //Add those frequency to minheap with custom comparator
        PriorityQueue<Map.Entry<String, Integer>> minheap = new PriorityQueue(new wordFreqComparartor());
        //Iterate over freq key-value pair
        for(Map.Entry<String, Integer> entry : freq.entrySet()) {    
            minheap.offer(entry);

            if(minheap.size() > k) 
                minheap.poll();
        }

        //Prepare for result from minheap
        List<String> res = new ArrayList<>();
        while(!minheap.isEmpty()) 
            //reverse order insertion and getKey() from Map.Entry<>
            res.add(0, minheap.poll().getKey());    
        
        return res;
    }
}

class wordFreqComparartor implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        //Searches for Same Frequency words to sort by Lexicography order for them only
        if(a.getValue().equals(b.getValue())) {
            return b.getKey().compareTo(a.getKey());
        }
        return a.getValue() - b.getValue();
    }
}