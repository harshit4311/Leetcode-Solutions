class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;

        int currentTime = 0;
        double total_waiting_time = 0;

        for(int i = 0; i < n; i++) {
            int arrivalTime = customers[i][0];
            int timeNeeded = customers[i][1];

            if(currentTime <= arrivalTime) {
                currentTime = arrivalTime;
            }

            currentTime += timeNeeded;
            int waitingTime_perOrder = currentTime - arrivalTime;
            total_waiting_time += waitingTime_perOrder;
        }

        return (double) total_waiting_time / n;
    }
}