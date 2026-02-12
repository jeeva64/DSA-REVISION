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
    public void reorderList(ListNode head) {
        ListNode result = new ListNode(0),copy = result;
        ListNode middle = middleList(head);
        
        ListNode left = head;
        ListNode right = reverseList(middle.next);
        middle.next = null;
        
        while(right != null){
            result.next = left; //add left list value
            left = left.next;   //move left list to next pointer
            result = result.next;   //move result to next pointer for right list values

            result.next = right;    //add right list value
            right = right.next;     //move right to next pointer
            result = result.next;   //move result to next pointer for coming iteration left list 
        }
        result.next = (left != null) ? left : right;
    }
    private ListNode reverseList(ListNode head){
        ListNode pn = null, temp = null;
        while(head != null){
            pn = head.next;
            head.next = temp;
            temp = head;
            head = pn;
        }
        return temp;
    }
    private ListNode middleList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}