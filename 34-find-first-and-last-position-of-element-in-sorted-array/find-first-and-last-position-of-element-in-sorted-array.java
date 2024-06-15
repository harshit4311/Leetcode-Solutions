class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] result = new int[2];

        // Smallest Index/Position
        result[0] = smallestIndex(arr, target);

        // Largest Index/Position
        result[1] = largestIndex(arr, target);

        return result;
    }

    public static int smallestIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(arr[mid] == target) {
                result = mid;
                end = mid - 1;
            }

            else if(arr[mid] < target) {
                start = mid + 1; 
            }

            else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static int largestIndex(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target) {
                result = mid;
                start = mid + 1;
            }

            else if(arr[mid] < target) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }
        
        return result;
    }
}