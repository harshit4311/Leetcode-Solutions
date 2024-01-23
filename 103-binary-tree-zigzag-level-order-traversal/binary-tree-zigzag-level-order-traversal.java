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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isReversed=true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode current = queue.poll();

                // Add the Left child at the end of the queue
                if(current.left != null){
                    queue.offer(current.left);
                }

                // Add the Right child at the end of the queue
                if(current.right != null){
                    queue.offer(current.right);
                }

                innerList.add(current.val);
            }

            // Reverse the list alternatively
            if(!isReversed){
                Collections.reverse(innerList);
            }

            list.add(innerList);

            // Toggle the isReversed variable for the next iteration
            isReversed = !isReversed;
        }

        return list;
    }
}