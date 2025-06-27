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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode dommy = new ListNode(0,head);
        ListNode endpointer=dommy;
        int i = 0;
        while(i<n+1 && endpointer != null)
        {

            endpointer = endpointer.next;
            i++;
        }

        ListNode nthpointer = dommy;

        while(endpointer!=null)
        {
            endpointer = endpointer.next;
            nthpointer = nthpointer.next;
        }
        nthpointer.next = nthpointer.next.next;
        

        return dommy.next;
    }
}
