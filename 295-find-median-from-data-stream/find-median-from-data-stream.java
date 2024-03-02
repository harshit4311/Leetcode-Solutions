class MedianFinder {

    public PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    public PriorityQueue<Integer> large = new PriorityQueue<>();
    public boolean even = true;

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.add(num);
            small.add(large.poll());
        } 
        else {
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */