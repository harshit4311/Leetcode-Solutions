class TrieNode {
    HashMap<Character, TrieNode> map;
    boolean isEnd;

    public TrieNode() {
        map = new HashMap<Character, TrieNode>();
        isEnd = false;
    }
}

class WordDictionary {
    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Add new TrieNode if not present
            if(!current.map.containsKey(ch)) {
                current.map.put(ch, new TrieNode());
            }

            // Else move to the next character
            current = current.map.get(ch);
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public boolean helper(String word, int i, TrieNode node) {
        if(i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);

        if(ch == '.') {
            // If '.', try all possible characters
            for(char nextChar : node.map.keySet()) {
                if(helper(word, i + 1, node.map.get(nextChar))) {
                    return true;
                }
            }
            return false;
        }
        else {
            // If not '.', move to the next character in the trie
            if (!node.map.containsKey(ch)) {
                return false; 
            }
            return helper(word, i + 1, node.map.get(ch));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */