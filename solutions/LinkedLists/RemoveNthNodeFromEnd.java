/**
 * Problem: RemoveNthNodeFromEnd
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for RemoveNthNodeFromEnd
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
 import java.util.*;
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        ListNode temp2 = head;
        ListNode ans = head;
        while(temp!=null){
            temp = temp.next;
            size = size+1;
        }
        int remove = size-n;
        int counter = 1;

        if(remove == 0){
            head = head.next;
            return head;
        }


        if(size == 1 && n == 1){
            return null;
        }
        while(counter!=remove){
            temp2 = temp2.next;
            counter++;
        }
        
        
        if(temp2.next != null && temp2.next.next!=null){
        
            temp2.next = temp2.next.next;
            return ans;
        }
        
        
        if(temp2.next == null || temp2.next.next == null){
            temp2.next=null;
        }


        return ans;

    }
}
