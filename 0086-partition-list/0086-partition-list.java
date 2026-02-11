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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode copyL = lesser;
        ListNode copyG = greater;

        while(head != null && lesser != null && greater != null){
            if(head.val < x){
                lesser.next = head;
                lesser = lesser.next;
            }
            if(head.val >= x){
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        lesser.next = copyG.next;
        return copyL.next;
    }
}