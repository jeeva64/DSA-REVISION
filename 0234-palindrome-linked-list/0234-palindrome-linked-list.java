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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        //Find Middle of the list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse First Half 
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(slow.next) ;

        //Compare with two pointer approach
        while(secondHalf != null) {
            if(firstHalf.val != secondHalf.val)     return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    //Reverse List by one Traversal Intuisions
    private ListNode reverse(ListNode head) {
        ListNode pn = null, temp = null;
        while(head != null) {
            pn = head.next;
            head.next = temp;
            temp = head;
            head = pn;
        }
        return temp;
    }
}