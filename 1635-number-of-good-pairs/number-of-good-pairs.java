class Solution {
    public int numIdenticalPairs(int[] arr) {
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i] == arr[j] && i < j) 
                count++;
            }
        }

        return count;
    }
}