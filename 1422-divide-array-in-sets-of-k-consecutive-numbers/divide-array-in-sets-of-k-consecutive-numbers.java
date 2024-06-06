class Solution {
    public boolean isPossibleDivide(int[] arr, int k) {
        if(arr.length % k != 0) {
            return false;
        }


        if(k == 1) {
            return true;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements to the PQ
        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        while(!pq.isEmpty()) {
            int start = pq.poll(); // Get the smallest card to start a group

            for(int i = 1; i < k; i++) {
                if(!pq.remove(start + i)) {
                    return false; // If we can't find the next consecutive card, return false
                }
            }
        }

        return true;
    }
}