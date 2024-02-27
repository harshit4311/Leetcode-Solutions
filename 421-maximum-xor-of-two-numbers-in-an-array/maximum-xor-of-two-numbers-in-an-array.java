class TrieNode{
    TrieNode left;
    TrieNode right;
}

class Solution {

    public void insert(TrieNode root, int num){
        TrieNode current = root;

        for(int i = 31; i >= 0; i--){
            int ithBit = (num >> i) & 1;

            if(ithBit == 0){
                if (current.left == null) {
                    current.left = new TrieNode();
                }
                current = current.left;
            }
            else{
                if (current.right == null) {
                    current.right = new TrieNode();
                }
                current = current.right;
            }
        }
    }

    public int maxXorFunction(TrieNode root, int num) {
    int maxXOR = 0;
    TrieNode current = root;

    for (int i = 31; i >= 0; i--){
        int ithBit = (num >> i) & 1;

        if (ithBit == 1){
            if (current.left != null){
                maxXOR += Math.pow(2, i);
                current = current.left;
            } 
            else{
                current = current.right;
            }
        } 

        else {
            if (current.right != null){
                maxXOR += Math.pow(2, i);
                current = current.right;
            } 
            else{
                current = current.left;
            }
        }
    }
    return maxXOR;
    }

    public int findMaximumXOR(int[] arr) {
        TrieNode root = new TrieNode();

        // inserting elements in the trie
        for(int i = 0; i < arr.length; i++){
            insert(root, arr[i]);
        }

        int result = 0;

        // finding the max. XOR
        for(int i = 0 ; i < arr.length; i++){
            result = Math.max(result, maxXorFunction(root, arr[i]));
        }
        return result;
    }
}