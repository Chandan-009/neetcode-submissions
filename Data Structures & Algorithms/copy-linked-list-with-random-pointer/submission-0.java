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
        Map<Integer,Node> position_rondom_map=new HashMap<>();
        Map<Integer,Node> position_node_map=new HashMap<>();
        Map<Node, Integer> node_map=new HashMap<>();
        int position=0;
        Node temp=head;

        Node dummy_node=new Node(-1);
        Node result_head=dummy_node;
        while(temp!=null) {
            // create result 
            Node cur=new Node(temp.val);
            dummy_node.next=cur;
            dummy_node=cur;
            // store position random map
            position_rondom_map.put(position,temp.random);
            // store old node position
            node_map.put(temp,position);
            // tract resulted position reference
            position_node_map.put(position,cur);
            //move temp
            temp=temp.next;
            //increase position
            position++;
        }

        dummy_node=result_head.next;
        int cur_position=0;
        // store raondom pointers
        while(dummy_node!=null) {
            Node rondom_posotion=position_rondom_map.get(cur_position);
            if(rondom_posotion==null){
               dummy_node.random=null;
            }
            else{
                int p=node_map.get(rondom_posotion);
                dummy_node.random=position_node_map.get(p);
            }
            cur_position++;
            dummy_node=dummy_node.next;
        }

        return result_head.next;
    }
}
