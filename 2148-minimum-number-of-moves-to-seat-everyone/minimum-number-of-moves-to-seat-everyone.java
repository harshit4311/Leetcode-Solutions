
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;

        int[] positionSeats = new int[101];
        int[] positionStudents = new int[101];

        Arrays.fill(positionSeats, 0);
        Arrays.fill(positionStudents, 0);

        // Count the number of seats at each position
        for (int i = 0; i < n; i++) {
            positionSeats[seats[i]]++;
        }

        // Count the number of students at each position
        for (int i = 0; i < n; i++) {
            positionStudents[students[i]]++;
        }

        int i = 0;
        int j = 0;
        int countMoves = 0;

        while(i < 101 && j < 101) {
            if(positionSeats[i] == 0) {
                i++;
                continue;
            }
            
            if(positionStudents[j] == 0) {
                j++;
                continue;
            }

            // Calculate the number of moves for one student to the seat
            countMoves += Math.abs(i - j);
            positionSeats[i]--;
            positionStudents[j]--;
        }

        return countMoves;
    }
}