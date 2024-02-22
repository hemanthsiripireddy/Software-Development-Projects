package org.example;

import java.util.HashSet;
import java.util.Set;


public class LinkedList {
    public boolean hasCycle(Node head){
        Set<Node> visited=new HashSet<>();
        Node cur=head;
        while(cur!=null){
            if(visited.contains(cur))
                return true;
            visited.add(cur);
            cur=cur.next;
        }
        return false;
    }
}
