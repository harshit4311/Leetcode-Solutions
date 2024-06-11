class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int length = 0;
        for(int i = 0; i < arr1.length; i++){
            length = Math.max(length, arr1[i]);
        }

        // Count array where each index represents the frequency of the current element
        int[] count = new int[length + 1];
        for(int i = 0; i < arr1.length; i++){
            count[arr1[i]]++;
        }

        // Place elements from arr2 in the 'ans' array
        int[] ans = new int[arr1.length];
        int index = 0;

        for(int i = 0; i < arr2.length; i++){
            while(count[arr2[i]] > 0){
                ans[index] = arr2[i];
                index++;
                count[arr2[i]]--;
            }
        }

        // Place all remaining elements of arr2(that are not present in arr1) in sorted order
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                ans[index] = i;
                index++;
                count[i]--;
            }
        }
        
        return ans;
    }
}