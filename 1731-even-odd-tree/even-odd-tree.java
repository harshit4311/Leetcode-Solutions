class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLevelEven = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int prev;

            if (isLevelEven) 
                prev = Integer.MIN_VALUE;
            else 
                prev = Integer.MAX_VALUE;

            boolean currentLevelEven = isLevelEven;
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (currentLevelEven) {
                    if (current.val % 2 == 0 || current.val <= prev) return false;
                } 
                else {
                    if (current.val % 2 != 0 || current.val >= prev) return false;
                }

                prev = current.val;

                if (current.left != null) queue.add(current.left);

                if (current.right != null) queue.add(current.right);
            }

            isLevelEven = !isLevelEven;
        }
        return true;
    }
}
