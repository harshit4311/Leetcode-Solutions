/*
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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;

        ListNode prev = null;
        ListNode current = head;
        int prefixSum = 0;

        while(current != null){
            prefixSum += current.val;

            if(prefixSum == 0){

                if(prev == null){
                    head = current.next;
                } 
                else{
                    prev.next = current.next;
                }
                return removeZeroSumSublists(head);
            }
            current = current.next;
        }
        
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}
