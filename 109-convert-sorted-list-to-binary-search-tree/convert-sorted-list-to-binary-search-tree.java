/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;

        while(fast != null && fast.next != null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the list at the middle point
        if(mid != null){
            mid.next = null;
        }

        TreeNode root = new TreeNode(slow.val);

    // Recursively adding the left and right subtrees
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);

    return root;
    }
}