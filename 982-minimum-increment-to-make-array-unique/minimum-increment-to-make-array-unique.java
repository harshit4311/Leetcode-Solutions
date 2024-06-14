class Solution {
    public int minIncrementForUnique(int[] arr) {
        Arrays.sort(arr);

        int count = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= arr[i - 1]) {
                int incrementByValue = arr[i - 1] - arr[i] + 1;
                arr[i] += incrementByValue;
                count+= incrementByValue;
            }
        }

        return count;
    }
}