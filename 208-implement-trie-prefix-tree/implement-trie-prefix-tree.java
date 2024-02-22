class TrieNode{
    HashMap<Character, TrieNode> map;
    boolean isEnd;

    public TrieNode(){
        map = new HashMap<Character, TrieNode>();
        isEnd = false;
    }
}

public class Trie{
    public TrieNode root;

    public Trie(){
        root = new TrieNode();    
    }
    
    public void insert(String word) {
    TrieNode current = root;
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);

        if (!current.map.containsKey(ch)) {
            current.map.put(ch, new TrieNode());
        }
        current = current.map.get(ch);
    }
    current.isEnd = true;
}
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            
            if(!current.map.containsKey(ch)){
                return false;
            }
            current = current.map.get(ch);
        }
        return current.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);

            if(!current.map.containsKey(ch)){
                return false;
            }
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