class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) {
            return false;
        }


        if(groupSize == 1) {
            return true;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements to the PQ
        for(int i = 0; i< hand.length; i++) {
            pq.add(hand[i]);
        }

        while(!pq.isEmpty()) {
            int start = pq.poll(); // Get the smallest card to start a group

            for(int i = 1; i < groupSize; i++) {
                if(!pq.remove(start + i)) {
                    return false; // If we can't find the next consecutive card, return false
                }
            }
        }

        return true;
    }
}