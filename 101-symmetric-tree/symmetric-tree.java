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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode Node1, TreeNode Node2){
        if(Node1 == null && Node2 == null) 
        return true;

        if(Node1 == null || Node2 == null) 
        return false;

        if(Node1.val != Node2.val) 
        return false;

        return (isMirror(Node1.left, Node2.right) && isMirror(Node1.right, Node2.left));

    }
}