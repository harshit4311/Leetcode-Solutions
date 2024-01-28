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
    public int count = 0;
    public int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    public void inOrderTraversal(TreeNode root, int k) {
        if (root == null || count >= k) {
            return;
        }

        inOrderTraversal(root.left, k);
        
        //Traversal for root.val
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inOrderTraversal(root.right, k);
    }
}
