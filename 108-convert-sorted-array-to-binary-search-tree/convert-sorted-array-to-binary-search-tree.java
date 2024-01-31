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
    public TreeNode sortedArrayToBST(int[] arr) {
        return BST(arr, 0, arr.length - 1);
    }

    public TreeNode BST(int[] arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode Node = new TreeNode(arr[mid]);
        Node.left = BST(arr, start, mid - 1);
        Node.right = BST(arr, mid + 1, end);

        return Node;
    }
}