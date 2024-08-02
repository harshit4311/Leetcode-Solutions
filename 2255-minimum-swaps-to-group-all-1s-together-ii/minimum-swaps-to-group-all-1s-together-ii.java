class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int oneCount = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == 1) {
                oneCount++;
            }
        }

        if(n == oneCount || oneCount == 0) {
            return 0;
        }

        int currentOnes = 0;
        for(int i = 0; i < oneCount; i++) {
            currentOnes += arr[i];
        }

        int maxOnes = currentOnes;

        for(int i = 0; i < n; i++) {
            currentOnes -= arr[i];
            currentOnes += arr[(i + oneCount) % n];
            maxOnes = Math.max(maxOnes, currentOnes);
        }

        return oneCount - maxOnes;
    }
}