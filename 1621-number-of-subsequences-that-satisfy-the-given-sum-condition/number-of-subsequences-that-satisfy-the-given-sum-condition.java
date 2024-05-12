class Solution {
    public int numSubseq(int[] arr, int target) {
        int MOD = 1_000_000_007;
        Arrays.sort(arr);

        long[] powerOfTwoArray = new long[arr.length];
        powerOfTwoArray[0] = 1;

        // Store values in the powerOfTwoArray
        for(int i = 1; i < arr.length; i++) {
            powerOfTwoArray[i] = (powerOfTwoArray[i - 1] * 2) % MOD;
        }

        int start = 0;
        int end = arr.length - 1;

        long count = 0;

        while(start <= end) {
            int sum = arr[start] + arr[end];

            if (sum <= target) {
                count += powerOfTwoArray[end - start];
                count %= MOD;
                start++;
            } 
            else {
                end--;
            }
        }

        return (int) count;
    }
}