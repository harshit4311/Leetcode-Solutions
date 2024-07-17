/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right; 
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ArrayList<TreeNode> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        // Add all "to_delete" (array) elements to the hashset
        for(int i : to_delete) {
            set.add(i);
        }

        // Helper function to delete nodes and collect forest
        deleteHelper(root, set, result);

        // If the root is not to be deleted, add it to the result
        if(!set.contains(root.val)) {
            result.add(root);
        }

        return result;
    }

    public TreeNode deleteHelper(TreeNode node, HashSet<Integer> set, ArrayList<TreeNode> result) {
        if(node == null) {
            return null;
        }

        node.left = deleteHelper(node.left, set, result);
        node.right = deleteHelper(node.right, set, result);

        if(set.contains(node.val)) {
            if(node.left != null) {
                result.add(node.left);
            }
            if(node.right != null) {
                result.add(node.right);
            }
            return null;  // Delete the node
        } 
        else {
            return node;
        }
    }
}
