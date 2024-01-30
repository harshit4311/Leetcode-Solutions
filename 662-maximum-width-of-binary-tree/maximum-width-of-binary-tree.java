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

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        // Level-Order Traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().index; // Keep track of min

            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                int currentIndex = queue.peek().index - min; // Adjusting index based on the min index of the level

                TreeNode node = queue.peek().node;
                queue.poll();

                if (i == 0) {
                    first = currentIndex; // Recording the index of the leftmost TreeNode 
                }

                if (i == size - 1) {
                    last = currentIndex; // Recording the index of the rightmost TreeNode 
                }

                // Add the left and right children to the queue with adjusted indices
                if (node.left != null) {
                    queue.add(new Pair(node.left, currentIndex * 2 + 1));
                }

                if (node.right != null) {
                    queue.add(new Pair(node.right, currentIndex * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1); // Updating max width
        }

        return ans;
    }
}