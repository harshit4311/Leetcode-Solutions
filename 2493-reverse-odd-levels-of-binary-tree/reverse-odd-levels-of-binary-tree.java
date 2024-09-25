import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

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

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOddLevel = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            List<Integer> oddLevelVal = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode); 

                if(isOddLevel) {
                    oddLevelVal.add(currentNode.val);
                }

                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }

            // similar to reversing an array
            if(isOddLevel) {
                for(int i = 0; i < oddLevelVal.size(); i++) {
                    currentLevelNodes.get(i).val = oddLevelVal.get(oddLevelVal.size() - 1 - i);
                }
            }

            isOddLevel = !isOddLevel;
        }
        return root;
    }
}
