class Solution {
    public int majorityElement(int[] arr) {
        Arrays.sort(arr);
        
        int n = arr.length;
        return arr[n/2];
    }
}