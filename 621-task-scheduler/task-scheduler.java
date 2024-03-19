class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }

        Arrays.sort(freq);

        int chunk = freq[25] - 1;
        int idle = chunk * n;

        for (int i = 24; i >= 0; i--) {
            if (chunk > freq[i]) {
                idle -= freq[i];
            } 
            else {
                idle -= chunk;
            }
        }

        if (idle < 0) return tasks.length;
        else return tasks.length + idle;
    }
}
