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

        if(head == null || head.next == null){
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
  
        ListNode secondListHead = slow.next; 
        slow.next = null;

        ListNode prev = null;        
        while(secondListHead != null){
            ListNode tempNode =  secondListHead.next; 
            secondListHead.next = prev;
            prev = secondListHead;
            secondListHead = tempNode;
        }

        secondListHead = prev;
        ListNode curr = head;
        while(secondListHead != null){
            ListNode nextFirst = curr.next;
            ListNode nextSecond = secondListHead.next;

            curr.next = secondListHead; 
            secondListHead.next = nextFirst;

            curr = nextFirst;
            secondListHead = nextSecond;            
        }

    }
}
