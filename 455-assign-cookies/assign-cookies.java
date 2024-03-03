class Solution {
    public int findContentChildren(int[] greed, int[] size) {

        if(size.length == 0) return 0;
        
        int count = 0;
        Arrays.sort(greed);
        Arrays.sort(size);
        
        int i = 0;
        int j = 0;
        
        for (i = 0, j = 0; i < greed.length && j < size.length; j++) {
            if (greed[i] <= size[j]) {
                count++;
                i++;
            }
        }

        return count;
    }
}
