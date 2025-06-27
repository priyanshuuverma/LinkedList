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
    public ListNode reverseLL(ListNode temp ){
        if(temp == null || temp.next == null) return temp;
        ListNode newHead = reverseLL(temp.next);
        ListNode front = temp.next;
        front.next = temp;
        temp.next = null;

        return newHead;
    }
    public ListNode rotateLL(ListNode temp, int k){
        k -= 1;
        while(temp != null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = new ListNode(-1);

        while(temp != null){
            ListNode kthNode = rotateLL(temp,k);
            if(kthNode == null){
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);
            if(temp == head){
                head = kthNode;
            }     
            else{
                prevNode.next = kthNode;

            }
            prevNode = temp;
            temp = nextNode;

        }
        return head;
    }
}
