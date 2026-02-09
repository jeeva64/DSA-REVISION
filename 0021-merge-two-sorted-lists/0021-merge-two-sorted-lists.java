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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Similiar to Merge Two Sorted Array
        ListNode result = new ListNode(-1);
        ListNode copy = result;

        while(list1 != null && list2 != null) {
            //CASE 1: Add list1 to result & move list1 to next
            if(list1.val <= list2.val) {
                result.next = list1;
                list1 = list1.next;
            } 
            //CASE 2: Add list2 to result & move list2 to next
            else {
                result.next = list2;
                list2 = list2.next;
            }
            //moves result node next for new node insertions
            result = result.next;
        }
        //Joins, m != n list to result (m size of l1 and n size of l2)
        result.next = (list1 != null) ? list1 : list2;

        return copy.next;
    }
}