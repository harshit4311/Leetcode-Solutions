/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
*/
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentDepth = 1;

        // Perform BFS until reaching the desired depth - 1
        while(currentDepth < depth - 1) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            currentDepth++;
        }

        // Add new nodes at the desired depth
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;

            if(leftChild != null) {
                TreeNode newLeft = new TreeNode(val);
                newLeft.left = leftChild;
                node.left = newLeft;
            } 
            else {
                node.left = new TreeNode(val);
            }

            if(rightChild != null) {
                TreeNode newRight = new TreeNode(val);
                newRight.right = rightChild;
                node.right = newRight;
            } 
            else {
                node.right = new TreeNode(val);
            }
        }

        return root;
    }
}
