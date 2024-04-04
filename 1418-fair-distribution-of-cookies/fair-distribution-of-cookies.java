class Solution {
    int result = Integer.MAX_VALUE;

    public void helper(int[] cookies, int start, int k, int[] temp) {
        if(start == cookies.length) {
            int max = 0;

            for(int j = 0; j < temp.length; j++) {
                max = Math.max(max, temp[j]);
            }
            result = Math.min(result, max);
            return;
        }

        for(int i = 0; i < k; i++) {
            temp[i] += cookies[start];
            helper(cookies, start + 1, k, temp);
            temp[i] -= cookies[start];
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return result;  
    }

}