class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        if(arr.length == 0) {
            return 0;
        }

        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int mod = sum % k;

            if(mod < 0) {
                mod += k;
            }

            // If the modulo has been seen before, it means we found a subarray
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            // Update the frequency of the current prefix sum modulo
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}