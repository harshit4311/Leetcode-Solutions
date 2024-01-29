/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        Queue<String> nodes = new LinkedList<>(List.of(data.split(",")));
        return deserializeHelper(nodes);
    }

    public TreeNode deserializeHelper(Queue<String> nodes) {
        String nodeVal = nodes.poll();

        if ("null".equals(nodeVal)) {
            return null;
        } 
        else {
            TreeNode newNode = new TreeNode(Integer.parseInt(nodeVal));
            newNode.left = deserializeHelper(nodes);
            newNode.right = deserializeHelper(nodes);
            return newNode;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
