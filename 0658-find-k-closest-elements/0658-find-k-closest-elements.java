class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //HEAP: With Custom comparator to find closest number k values from x in the arr
        PriorityQueue<Integer> minheap = new PriorityQueue<>(new closestComparator(x));
        for(int num : arr) {
            minheap.offer(num);

            if(minheap.size() > k)
                minheap.poll();
        }

        //Computen Result from heap
        List<Integer> res = new ArrayList<>(minheap);
        Collections.sort(res);
        return res;
    }
}

class closestComparator implements Comparator<Integer> {
    private int x;
    public closestComparator(int x){
        this.x = x;
    }
    
    public int compare(Integer a, Integer b) {
        int diff = Math.abs(b-x) - Math.abs(a-x);
        if(diff == 0)
            return b-a;

        return diff;
    }
}