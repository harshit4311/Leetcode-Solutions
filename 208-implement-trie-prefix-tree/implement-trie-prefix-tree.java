import java.util.*;

class TrieNode {
    HashMap<Character, TrieNode> map;
    boolean isEnd;

    public TrieNode() {
        map = new HashMap<Character, TrieNode>();
        isEnd = false;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Case 1: If character 'ch' is not present 
            if(!current.map.containsKey(ch)) {
                current.map.put(ch, new TrieNode());
            }

            // Case 2: If character 'ch' is present
            current = current.map.get(ch); 
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // Does not contain character, so will not contain the String 'word'
            if(!current.map.containsKey(ch)) {
                return false;
            }


            // Move to the next character index
            current = current.map.get(ch);
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            // Does not start with ch
            if(!current.map.containsKey(ch)) {
                return false;
            }

            // Move to the next character
            current = current.map.get(ch);
        } 
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */