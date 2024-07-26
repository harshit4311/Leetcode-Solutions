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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }

        int mid = count / 2;

        // Traverse to (mid-1)th node
        current = head;
        for(int i = 0; i < mid - 1; i++) {
            current = current.next;
        }

        // Delete mid node
        if(current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }
}