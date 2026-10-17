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
        int carry = 0;
        ListNode current = null;
        ListNode start = null;

        while(l1 != null || l2 != null){
            int num1 = 0;
            if(l1 != null){
               num1 = l1.val;
               l1 = l1.next;     
            }
            int num2 = 0;
            if(l2 != null){
                num2 = l2.val;                   
                l2 = l2.next;
            }
            int sum =  (num1+num2)+carry;
            ListNode newNode = getNewNode(sum);
            current = updateCurrent(newNode, current, start);
            if(start == null){
                start = current;
            }
            carry = sum > 9 ? sum/10 : 0;            
        }

        // while(l1 != null){
        //     int sum =  l1.val+carry;
        //     l1 = l1.next;
        //     ListNode newNode = getNewNode(sum);
        //     current = updateCurrent(newNode, current, start);         
        //     if(start == null){
        //         start = current;
        //     }            
        //     carry = sum > 9 ? sum/10 : 0; 
        // }
        // while(l2 != null){
        //     int sum =  l2.val+carry;
        //     l2 = l2.next;            
        //     ListNode newNode = getNewNode(sum);
        //     current = updateCurrent(newNode, current, start);
        //     if(start == null){
        //         start = current;
        //     }            
        //     carry = sum > 9 ? sum/10 : 0; 
        // }
        if(carry != 0){
           ListNode newNode = new ListNode(carry, null); 
           current = updateCurrent(newNode, current, start);
            if(start == null){
                start = current;
            }           
        }        
        return start;                        
    } 

    private ListNode getNewNode(int sum){
        ListNode node;
        if(sum > 9){                                         
            node = new ListNode((sum%10), null);
        }else{
            node = new ListNode((sum), null);
        }
        return node;        
    }

    private ListNode updateCurrent(ListNode node, ListNode current, ListNode start){        
        if(current != null) {             
            current.next = node;
            current = node;
        } else {
            current = node; 
        }
        return current;
    }   
}
