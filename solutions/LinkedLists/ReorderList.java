/**
 * Problem: ReorderList
 * Difficulty: TBD
 * URL: https://leetcode.com/problems/
 *
 * TODO: implement solution for ReorderList
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
    public void reorderList(ListNode head) {
        HashMap<Integer,ListNode> hm = new HashMap<>();

        ListNode temp = head;
        int size = 0;

        while(temp!=null){
            temp=temp.next;
            size++;
        }
        
        if(size == 1){
            return;
        }
        if(size == 0){
            return;
        }
        temp = head;
        int count = 1;
        while(temp!=null){
            hm.put(count,temp);
            temp = temp.next;
            count+=1;
        }
        temp = head;

        int left =2;
        int right = size;
        int counter=0;
        while(left<=right){
            
                temp.next = hm.get(right);
                right--;
                temp=temp.next;
                
                if(left>right){
                    break;
                }
            
                temp.next = hm.get(left);
                temp =temp.next;
                System.out.print(temp.val);
                left++;
            
            
        }
        temp.next = null;
        


        
    }
}
