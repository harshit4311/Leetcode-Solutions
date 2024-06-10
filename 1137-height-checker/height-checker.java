class Solution {
    public int heightChecker(int[] heights) {
        int[] newArr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(newArr);

        int count = 0;

        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != newArr[i]) {
                count++;
            }
        }

        return count;
    }
}