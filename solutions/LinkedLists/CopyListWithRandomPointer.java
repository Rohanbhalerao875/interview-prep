/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> hm = new HashMap<>();
        
        Node temp = head;
        
        while (temp != null){
            hm.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp = head;

        while(temp!=null){
            hm.get(temp).next = hm.get(temp.next);
            hm.get(temp).random = hm.get(temp.random);
            temp = temp.next;

        }
        return hm.get(head);

// map.get(temp).next = map.get(temp.next);
// 'B'.next = C'



    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head ==null){
            return null;
        }
        Node temp = head;

         // Pass 1: Insert copied nodes
         while(temp!=null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;   // now what do we have here A-A' B-B' hence A.random.next = A therefore we can write A.next.random which is A'.random = A.random.next;
         }
        temp = head;
         // lets put the randoms now 
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random = temp.random.next;
                
            }
            temp=temp.next.next;  // only the original list we have to look at hence temp.next.next in the second pass A A' B B' we want only A B hence temp.next.next;
        }

        //now we create our copied list 
        temp = head;
        Node dummy = new Node(0);
        Node copy = dummy;
        while(temp!=null){
            copy.next = temp.next;  //copy.next () = temp.next(A');
            copy = copy.next;  // copy.next = A';

            temp.next = temp.next.next;  // this is for returning the original list in its place 
            temp = temp.next; // this is for just going to the next pointer 

        }
    return dummy.next;

    }
}
