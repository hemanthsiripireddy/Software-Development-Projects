package org.example;

public class Node{
    int val;
    Node next;
    public Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
    public Node(int val){
        this.val=val;

    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }
}