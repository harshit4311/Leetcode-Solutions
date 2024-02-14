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
    TreeNode prev, first, mid, last;

    public void recoverTree(TreeNode root) {
        first = mid = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        // swap the 'first' and 'last' nodes
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }

        // swap the 'first' and 'mid' nodes
        else if(first != null && mid != null){
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && (root.val < prev.val)){

            // if this is the 1st violation, mark these nodes as 'first' and 'mid'
            if(first == null){
                first = prev;
                mid = root;
            }

            // if this is the 2nd violation, mark this node as 'last'
            else{
                last = root;
            }
        }

        // mark this node as prev
        prev = root;
        inorder(root.right);
    }
}