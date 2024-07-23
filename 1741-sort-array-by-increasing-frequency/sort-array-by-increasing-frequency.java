class Solution {
    public int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        // Frequency map
        for(int i : arr) {
            list.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Custom sort based on 'frequency' and 'value'
        Collections.sort(list, (a, b) -> {
            if(map.get(a) == map.get(b)) {
                return b - a; // Sort in descending order 
            }
            else {
                return map.get(a) - map.get(b); // Sort by frequency in ascending order
            }
        });
        
        // Change arraylist to array to satisfy the return type of the function
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}