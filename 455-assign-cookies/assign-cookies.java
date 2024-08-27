class Solution {
    public int findContentChildren(int[] greedFactor, int[] size) {
        if (size.length == 0) {
            return 0;
        }

        Arrays.sort(greedFactor);
        Arrays.sort(size);

        int left = 0;
        int right = 0;

        while (left < size.length && right < greedFactor.length) {
            if (size[left] >= greedFactor[right]) {
                right++;
            }

            left++;

        }

        return right;
    }
}