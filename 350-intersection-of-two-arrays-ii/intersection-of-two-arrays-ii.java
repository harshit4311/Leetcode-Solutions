class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersectionList = new ArrayList<>();

        for(int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            
            if(map.containsKey(num) && map.get(num) > 0) {
                intersectionList.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[intersectionList.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = intersectionList.get(i);
        }

        return result;
    }  
}