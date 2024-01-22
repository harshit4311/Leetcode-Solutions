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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int levels = queue.size();
            List<Integer> subLevels = new ArrayList<>();

            for(int i = 0; i < levels; i++){
                 
                // Retrieve and remove the head of the current queue
                TreeNode current = queue.poll(); 

                // Adding the left child
                if (current.left != null) {
                    queue.add(current.left);
                }

                // Adding the right child
                if (current.right != null) {
                    queue.add(current.right);
                }
                subLevels.add(current.val);
            }

            result.add(subLevels);
        }

        return result;
    }
}