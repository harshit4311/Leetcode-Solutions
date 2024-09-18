class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] arr = new String[n];

        for(int i = 0; i < n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }   

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);
            } 
        });

        // largest number is 0
        if(arr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for(String str : arr) {
            result.append(str);
        }
        return result.toString();

    }
}