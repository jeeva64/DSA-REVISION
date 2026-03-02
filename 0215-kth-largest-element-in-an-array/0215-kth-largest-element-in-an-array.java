class Solution {
    public int findKthLargest(int[] nums, int k) {
        //Minimum Heap: KEEPS SMALL VALUE AT ROOT & LARGE VALUE AT LEAF NODES
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num : nums) {
            //Adds each number to minheap
            minHeap.offer(num);

            //It removes those small elements at the root node, whenever heap size is > k
            if(minHeap.size() > k)
                minHeap.poll();
        }
        //after all removal at top, current peek/top is kth largest num
        return minHeap.peek();
    }
}