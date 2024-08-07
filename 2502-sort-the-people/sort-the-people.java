class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();

        // Map heights<-->names array
        for(int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] result = new String[names.length];

        int index = 0;
        for(int i = heights.length - 1; i >= 0; i--) {
            result[index] = map.get(heights[i]);
            index++;
        }

        return result;
    }
}