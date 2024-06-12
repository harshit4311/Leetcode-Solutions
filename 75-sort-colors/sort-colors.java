class Solution {
    public void sortColors(int[] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        // Count occurrences of all the colors
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                zeroCount++;
            }

            else if(arr[i] == 1) {
                oneCount++;
            }

            // arr[i] == 2
            else { 
                twoCount++;
            }
        }

        int index = 0;

        // Firstly, place all 0's in the array
        for(int i = 0; i < zeroCount; i++) {
            arr[index] = 0;
            index++;
        }

        // Place all 1's in the array (after all 0's are placed)
        for(int i = 0; i < oneCount; i++) {
            arr[index] = 1;
            index++;
        }

        // Place all 2's in the array (after all 0's and 1's are placed)
        for(int i = 0; i < twoCount; i++) {
            arr[index] = 2;
            index++;
        }

    }
}