/**
 * Problem: MergeTwoSortedLists
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for MergeTwoSortedLists
 */

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
        ListNode ans = new ListNode(-1);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode tail = ans;

        if(list1== null){
            return list2;
        }
        if(list2== null){
            return list1;
        }
        if(list1== null && list2==null){
            return ans.next;
        }
        
        if(temp1.val<=temp2.val){
            tail.next = temp1;
            temp1 = temp1.next;
            tail = tail.next;
        }else{
            tail.next = temp2;
            temp2=temp2.next;
            tail = tail.next;
        }

        while(temp1!=null && temp2!=null){
        if(temp1.val<=temp2.val){
            tail.next = temp1;
                temp1 = temp1.next;
                tail = tail.next;
            
        }else{
            tail.next = temp2;

                temp2 = temp2.next;
            tail = tail.next;
            
        }
        }
        while(temp1!=null){
            tail.next = temp1;

                temp1 = temp1.next;
            tail = tail.next;
            
        }
        while(temp2!=null){
                tail.next = temp2;
   
                temp2 = temp2.next;
            tail = tail.next;
            
        }

        
    
    return ans.next;
    }
}
