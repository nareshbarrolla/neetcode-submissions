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

        int length = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        int removeNodeIndx;
        if(length < n){
            // nothing to delete since provided nth index is grather then given list
            return head;            
        }else{
            removeNodeIndx = length - n;
        }

        if(removeNodeIndx == 0){            
            return head.next;
        }else{
            length = 0;
            temp = head;
            ListNode prev = head;
            while(temp != null){
                if(length == removeNodeIndx){
                  prev.next = temp.next;
                  break;
                }
                prev = temp;
                temp = temp.next;
                length = length+1;
            }
        }
        return head;           
    }
}
