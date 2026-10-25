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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        
        int temp = n;
        while(fast.next != null && temp != 0){
            fast = fast.next;
            temp = temp-1;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(temp > 0){
            head = slow.next;
        }else{
            // Remove the slow's next node
            slow.next = slow.next != null ? slow.next.next : null;
        }     
        return head;                
    }
}
