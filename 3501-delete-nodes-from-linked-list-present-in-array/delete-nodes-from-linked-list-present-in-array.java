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
    public ListNode modifiedList(int[] arr, ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        // Add all the elements of the array to the HashSet
        for(int num : arr) {
            set.add(num);
        }

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode current = temp;

        while(current.next != null) {
            if(set.contains(current.next.val)) {
                current.next = current.next.next;
            } 
            else {
                current = current.next;
            }
        }

        // Skip the dummy node and return the list
        return temp.next;
    }
}