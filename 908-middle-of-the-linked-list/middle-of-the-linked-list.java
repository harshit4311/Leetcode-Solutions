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
    public ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }

        int count = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            count++;
        }

        if(count % 2 == 0) {
            int mid = (count / 2) + 1;
        }
        int mid = count / 2;

        current = head;
        for(int i = 0; i < mid; i++) {
            current = current.next;
        }

        return current;
    }
}