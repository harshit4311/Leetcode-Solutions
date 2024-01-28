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
    public TreeNode deleteNode(TreeNode root, int target) {
        
        if(root == null){
            return null;
        }

        if(root.val == target){
            return helperRoot(root);
        }

        // Create a dummy variable to keep track of the original root
        TreeNode dummy = root;

        while(root != null){

            // If the left child's value matches the target, call helperRoot to delete it
            if(root.val > target){
                if(root.left != null && root.left.val == target){
                    root.left = helperRoot(root.left);
                    break;
                }

                else{
                    root = root.left;
                }
            }

            else{

                // If the left child's value matches the target, call helperRoot to delete it
                if(root.right != null && root.right.val == target){
                    root.right = helperRoot(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy; // Return the updated root of the tree
    }

    public TreeNode helperRoot(TreeNode root){
        if(root.left == null){
            return root.right;
        }

        if(root.right == null){
            return root.left;
        }

        // If both left and right children exist, find the last right child of the left subtree
        TreeNode rightChild = root.right;
        TreeNode lastRightChild = findLastRightChild(root.left);

        // Attach the right subtree to the right of the last right child
        lastRightChild.right = rightChild;

        // Return the modified left subtree
        return root.left;
    }

    public TreeNode findLastRightChild(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findLastRightChild(root.right);
    }
}