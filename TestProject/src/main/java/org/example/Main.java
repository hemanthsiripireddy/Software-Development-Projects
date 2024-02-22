package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        Node head=new Node(1);
//        Node cur=head;
//        List<Node>nodes=new ArrayList<>();
//        nodes.add(head);
//        for(int i=2;i<=8;i++){
//            Node temp=new Node(i);
//            nodes.add(temp);
//            cur.setNext(temp);
//            cur=temp;
//
//        }
//       // cur.setNext(nodes.get(2));
//        LinkedList linkedList=new LinkedList();
//        boolean res=linkedList.hasCycle(head);
//        System.out.println(res);

      List<List<Integer>> res=  FindAllPosiblePostiveNumber.rec(5);
      //  System.out.println(res);
        for (List<Integer> list:res){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}