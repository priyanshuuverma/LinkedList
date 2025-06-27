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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null|| l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

           ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry =  0;
        while(l1 != null || l2 != null){
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
                if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum = sum + carry ;
            carry = sum / 10;
            int res = sum%10;
            ListNode newN = new ListNode(res, null);
            head.next = newN;
            head = newN;
        }
        if(carry != 0){
            head.next = new ListNode(carry,null);
            head = head.next;
        }
        return curr.next;
    }
}
