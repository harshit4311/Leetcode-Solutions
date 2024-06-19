class Solution {
    public int minDays(int[] arr, int m, int k) {
        int n = arr.length;

        if (n < m * k) {
            return -1;
        }

        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++) {
            end = Math.max(end, arr[i]);
        }

        int minDaysResult = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(canMakeBouquets(arr, mid, k) >= m) {
                minDaysResult = mid;
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        return minDaysResult;
    }

    public int canMakeBouquets(int[] arr, int mid, int k) {
        int bouquetCount = 0;
        int consecutiveFlowersCount = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= mid) {
                consecutiveFlowersCount++;
            } 
            else {
                consecutiveFlowersCount = 0;
            }

            if(consecutiveFlowersCount == k) {
                bouquetCount++;
                consecutiveFlowersCount = 0;
            }
        }

        return bouquetCount;
    }
}
