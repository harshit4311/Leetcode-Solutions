class Solution {
    public List<Integer> findPeaks(int[] arr) {
        int n = arr.length;
        
        List<Integer> result = new ArrayList<>();
        
        // if(n == 0) return result;
        // if(n == 1) return result.add(arr[0]);
        // if(n == 2) return result.add(Math.max(arr[0], arr[1]));

        for(int i = 1; i < n - 1; i++) {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                result.add(i);
            }
        }

        return result;
    }
}