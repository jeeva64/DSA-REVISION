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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        
        //For Result
        ListNode oddHead = head, evenHead = head.next;
        //For Iterations
        ListNode odd = head, even = head.next;

        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            //Move pointer to unvisited node
            odd = odd.next;
            even = even.next;
        }
        //Connect odd last node to even head node
        odd.next = evenHead;

        return oddHead;
    }
}