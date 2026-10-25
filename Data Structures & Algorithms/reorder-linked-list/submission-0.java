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

        int length = 0;
        ListNode temp = head;        
        while(temp != null){
            temp = temp.next;
            length = length+1;                
        }
        int midPoint = length%2 != 0 ? (length/2)+1 : length/2;

        ListNode curr = head; 
        for(int i = 1; i < midPoint; i++){
            curr = curr.next;                
        }

        ListNode secondListHead = curr.next; 
        curr.next = null;

        temp = secondListHead;
        ListNode prev = null;        

        while(temp != null){
            ListNode tempNode =  temp.next;                            
            temp.next = prev;
            prev = temp;
            temp = tempNode;
        }

        secondListHead = prev;
        curr = head;
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
