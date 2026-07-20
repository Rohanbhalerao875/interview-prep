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
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }


        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;

        while(curr!=null){
        //n=cn cn=p p=c c=n
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        }

        ListNode first = head;
        ListNode second = prev;

        while(second!=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;
            
            first = temp1;
            second = temp2;


        }


    }
}
