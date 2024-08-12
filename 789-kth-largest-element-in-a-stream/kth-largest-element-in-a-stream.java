class KthLargest {
    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] arr) {
        this.k = k;

        queue = new PriorityQueue<Integer>(k);
        for (int a : arr) {
            add(a);
        }
    }
    
    public int add(int val) {
        queue.add(val);

        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */