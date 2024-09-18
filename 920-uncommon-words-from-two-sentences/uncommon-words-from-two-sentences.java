class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        // add words of sentence-1 to hashmap
        for(String word : words1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // add words of sentence-2 to hashmap
        for(String word : words2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> uncommon_words = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                uncommon_words.add(entry.getKey());
            }
        }
        return uncommon_words.toArray(new String[0]);

    }
}