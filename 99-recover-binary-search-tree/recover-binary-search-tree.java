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
    public TreeNode prev = null, ans1 = null, ans2 = null;

    public void recoverTree(TreeNode root){    
        if(root == null) return;

        // Perform in-order traversal to find the swapped nodes
        inorder(root);

        // Swap the values
        int temp = ans1.val;
        ans1.val = ans2.val;
        ans2.val = temp;
    }

    public void inorder(TreeNode root){
        if(root == null) return;

        // Recursively traverse the left subtree
        inorder(root.left);

        // Check if the current node violates the BST property
        if(prev != null){

            // If this is the first violation, update the values of 'ans1' and 'ans2'
            if(root.val < prev.val){
                if(ans1 == null){
                    ans1 = prev;
                    ans2 = root;
                }

                // If this is the second violation, update the value of just 'ans2'
                else{
                    ans2 = root;
                }
            }
        }
        prev = root;
        inorder(root.right); // Recursively traverse the right subtree
    }
}