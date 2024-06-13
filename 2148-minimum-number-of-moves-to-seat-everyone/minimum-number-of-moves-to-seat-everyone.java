class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int count = 0;

        // Count the difference in the positions of each seat and student 
        // Increment the count for each differnece in positions
        for(int i = 0; i < seats.length; i++) {
            count += Math.abs(students[i] - seats[i]);
        }

        return count;
    }
}