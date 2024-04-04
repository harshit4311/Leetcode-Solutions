class Solution {
    int result = Integer.MAX_VALUE;

    public void helper(int[] cookies, int start, int k, int[] count) {
        if(start == cookies.length) {
            int max = 0;

            for(int j = 0; j < count.length; j++) {
                max = Math.max(max, count[j]);
            }
            result = Math.min(result, max);
            return;
        }

        for(int i = 0; i < k; i++) {
            count[i] += cookies[start];
            helper(cookies, start + 1, k, count);
            count[i] -= cookies[start];

            if(count[i] == 0) {
                break;
            }
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return result;  
    }

}