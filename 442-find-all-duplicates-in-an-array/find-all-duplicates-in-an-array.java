class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : map.keySet()) {
            if(map.get(num) == 2) {
                list.add(num);
            }
        }

        return list;
    }
}