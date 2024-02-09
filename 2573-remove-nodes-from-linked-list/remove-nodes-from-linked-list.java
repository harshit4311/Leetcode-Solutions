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
class Solution {
    int max = 0;
    
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        
        head.next = removeNodes(head.next);
        
        if (head.val < max) {
            return head.next;
        }
        
        max = Math.max(max, head.val);
        
        return head;
    }
}
