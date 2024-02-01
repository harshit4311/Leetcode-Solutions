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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null && head2 == null) return null;

        if(head1 == null) return head2;

        if(head2 == null) return head1;

        else{
            if(head1.val < head2.val){
                head1.next = mergeTwoLists(head1.next, head2);
                return head1;
            }
            else{
                head2.next = mergeTwoLists(head1, head2.next);
                return head2;
            }
        }
    }


    // Code for Returning the Sorted Linked List in Decreasing/Reverse Order

    // public ListNode reverseList(ListNode head){
    //     ListNode temp = head;
    //     ListNode prev = null;

    //     while(temp != null){
    //        ListNode front = temp.next;
    //        temp.next = prev;
    //        prev = temp;
    //        temp = front;
    //     }

    //     return prev;
    // }

    // public ListNode decreasingOrderList(ListNode head1, ListNode head2){
    //     ListNode mergedList = mergeTwoLists(head1, head2);
    //     return decreasingOrderList(mergedList);
    // }
}