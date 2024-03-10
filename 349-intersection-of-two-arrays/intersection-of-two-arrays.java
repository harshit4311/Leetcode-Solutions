class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];

            if (set1.contains(num))
                intersectionSet.add(num);
        }

        int[] resultArray = new int[intersectionSet.size()];
        int intersectionIndex = 0;
        
        for (Integer num : intersectionSet) {
            resultArray[intersectionIndex++] = num;
        }

        return resultArray;
    }
}
