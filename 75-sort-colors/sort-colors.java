class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        
        // <color, frequency> map
        HashMap<Integer, Integer> colorCount = new HashMap<>();

        // Initialising the map with count = 0 for all colors
        colorCount.put(0, 0);
        colorCount.put(1, 0);
        colorCount.put(2, 0);

        // Count the occurences of each color 
        for(int i = 0; i < arr.length; i++) {
            int number = arr[i];
            colorCount.put(number, colorCount.get(number) + 1);
        }

        int index = 0;

        // Add all 0's in the array
        for (int i = 0; i < colorCount.get(0); i++) {
            arr[index++] = 0;
        }
        
        // Add all 1's in the array
        for (int i = 0; i < colorCount.get(1); i++) {
            arr[index++] = 1;
        }
        
        // Add all 2's in the array
        for (int i = 0; i < colorCount.get(2); i++) {
            arr[index++] = 2;
        }

    }
}