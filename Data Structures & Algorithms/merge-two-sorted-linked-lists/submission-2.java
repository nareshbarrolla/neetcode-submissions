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
        ListNode start = null;        
        ListNode tail = null;
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }        
        while(list1 != null && list2 != null){
            ListNode selected = null;
            if(list1.val <= list2.val){
                selected = list1;
                list1 = list1.next;
            }else{
                selected = list2;
                list2 = list2.next;
            }
            if(start == null){
               start = selected;
            }else{
               tail.next = selected; 
            }
            tail = selected;
        }
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }        
        return start;         
    }
}