class Solution {
    public int findContentChildren(int[] greedFactor, int[] size) {
        if (size.length == 0) {
            return 0;
        }

        Arrays.sort(greedFactor);
        Arrays.sort(size);

        int count = 0;

        int right = 0;

        for (int left = 0; left < size.length && right < greedFactor.length; left++) {
            if (size[left] >= greedFactor[right]) {
                right++;
            }
        }
        return right;
    }
}