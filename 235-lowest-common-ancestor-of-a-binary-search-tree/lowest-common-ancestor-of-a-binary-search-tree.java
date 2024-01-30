/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        int currentVal = root.val;

        // If both nodes are greater than the current node, move to the right subtree.
        if(currentVal < p.val && currentVal < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        // If both nodes are smaller than the current node, move to the left subtree.
        if(currentVal > p.val && currentVal > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}