class Solution {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();

        for(String time : timePoints) {
            String[] parts = time.split(":");
            
            int hrs = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);

            list.add(hrs * 60 + mins);
        }

        Collections.sort(list);

        int MIN = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++) {
            int pair_diff = list.get(i) - list.get(i - 1);

            MIN = Math.min(MIN, pair_diff);
        }

        int total_mins_in_a_day = 24 * 60;
        int largest_mins = list.get(list.size() - 1);
        int smallest_mins = list.get(0);

        int circular_diff = total_mins_in_a_day - (largest_mins - smallest_mins);
        MIN = Math.min(MIN, circular_diff);

        return MIN;
    }
}