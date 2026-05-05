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
    public ListNode rotateRight(ListNode head, int k) {
        //Edge Case
        if(head == null || head.next == null || k == 0)     return head;

        int n = findLength(head);
        ListNode endNode = getEndNode(head);
        //Shrinks within length for pruning extra rotations
        k %= n;

        //Convert into Circular Linked List
        endNode.next = head;

        //Finds k position & 
        int idx = 0;
        ListNode slow = null, fast = head;
        while(idx != n-k-1) {
            idx++;
            slow = fast;
            fast = fast.next;
        }

        //Breaks circular linkedlist and return next node
        ListNode result = fast.next;
        fast.next = null;
        return result;
    }
    private ListNode getEndNode(ListNode head) {
        ListNode dummy = head;

        while(dummy.next != null) {
            dummy = dummy.next;
        }
        return dummy;
    }
    private int findLength(ListNode head) {
        int len = 0;
        ListNode dummy = head;
        while(dummy != null) {
            len++;
            dummy = dummy.next;
        }
        return len;
    }
    
}