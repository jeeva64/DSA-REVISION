class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Edge case: empty input
        if (nums == null || nums.length == 0) 
            return new int[0];

        // Deque will store indices, not values
        // Front of deque always holds index of current window's max
        Deque<Integer> dq = new LinkedList<>();

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            // Remove indices that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // Remove smaller elements from the back
            // They can't be max if current element is bigger
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            // Add current index
            dq.offerLast(i);

            // Start recording results once first window is formed
            if (i >= k - 1)
                result[i - k + 1] = nums[dq.peekFirst()];
        }

        return result;
    }
}
