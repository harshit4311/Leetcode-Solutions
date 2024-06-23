class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int start = 0;
        int result = 0;
        int oddCount = 0;
        int temp = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 1) {
                oddCount++;
                temp = 0;
            }

            while(oddCount == k) {
                temp++;
                if(arr[start] % 2 == 1) {
                    oddCount--;
                }
                start++;
            }

            result += temp;
        }

        return result;
    }
}