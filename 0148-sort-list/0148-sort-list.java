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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = middleList(head);
        
        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return mergeTwoList(left,right);
    }
    public static ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode result = new ListNode(-1);
        ListNode copy = result;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                result.next = list1;
                list1 = list1.next;
            }else{
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        result.next = (list1 != null) ? list1 : list2;
        return copy.next;
    }
    public static ListNode middleList(ListNode node){
        ListNode slow = node, fast = node, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null)    prev.next = null;
        return slow;
    }
}