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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == rightHeight){
            // Perfectly balanced tree
            return (1 << leftHeight) + countNodes(root.right);
        } 
        else{
            // Not perfectly balanced, so recurse on left and right subtrees
            return countNodes(root.left) + (1 << rightHeight);
        }
    }   

    public int getHeight(TreeNode node) {
        if(node == null) return 0;

        // Assuming the tree is balanced, we only need to calculate the height of the left subtree
        return 1 + getHeight(node.left); 
    }
}