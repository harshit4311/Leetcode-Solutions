class Solution {
    public int[] getConcatenation(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[2 * n];

        for(int i = 0; i < n; i++) {
            newArr[i] = arr[i];
            newArr[i + n] = arr[i];
        }

        return newArr;
    }
}