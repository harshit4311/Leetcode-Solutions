class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] newArr = arr.clone();
        Arrays.sort(newArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        
        // assign ranks
        for(int i = 0; i < newArr.length; i++) {
            if(!map.containsKey(newArr[i])) {
                map.put(newArr[i], rank);
                rank++;
            }
        }

        // replace wrt original array with rank
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}