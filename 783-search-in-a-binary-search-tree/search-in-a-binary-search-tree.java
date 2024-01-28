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
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null || root.val == val){
            return root;
        }

        // Search on the left side
        if(val < root.val){
            return searchBST(root.left, val);
        }

        // Search on the right side
        else{
            return searchBST(root.right, val);
        }

    }
}