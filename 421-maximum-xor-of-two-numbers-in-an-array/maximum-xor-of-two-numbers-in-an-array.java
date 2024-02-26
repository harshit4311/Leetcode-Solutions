import java.util.*;

class TrieNode {
    TrieNode[] children;

    TrieNode() {
        this.children = new TrieNode[2];
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Inserts a number into the Trie
    public void insert(int num) {
        TrieNode current = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            if (current.children[bit] == null) {
                current.children[bit] = new TrieNode();
            }
            current = current.children[bit];
        }
    }

    // Finds the maximum XOR for a given number
    public int findMaxXOR(int num) {
        TrieNode current = root;
        int maxXOR = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int flipBit = bit ^ 1; // flip the bit to maximize XOR

            if (current.children[flipBit] != null) {
                maxXOR |= (1 << i); // Set the bit in the result
                current = current.children[flipBit];
            } 
            else {
                current = current.children[bit];
            }
        }
        return maxXOR;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        // Insert all numbers into the Trie
        for (int i = 0; i < nums.length; i++) {
            trie.insert(nums[i]);
        }

        int maxXOR = Integer.MIN_VALUE;

        // Iterate through all numbers to find maximum XOR
        for (int i = 0; i < nums.length; i++) {
            maxXOR = Math.max(maxXOR, trie.findMaxXOR(nums[i]));
        }

        return maxXOR;
    }
}
