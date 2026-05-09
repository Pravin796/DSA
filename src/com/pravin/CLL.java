package com.pravin;

public class CLL {
    private Node head;
    private Node tail;

    public CLL(){
        this.head = null;
        this.tail = null;
    }

    public void insertFirst(int val){
        Node node = new Node(val);

        if(head == null){
            head = node;
            tail = node;
            node.next = head;
        }else{
            node.next = head;
            head = node;
            tail.next = head;
        }
    }

    public void insertLast(int val){
        if(head == null){
          insertFirst(val);
          return;
        }

        Node node = new Node(val);
        tail.next = node;
        node.next = head;
        tail = node;
    }
    public void display(){
        Node node = head;
        if(head != null){
         do {
             IO.print(node.val + "->");
             node = node.next;
         }while (node != head);
        }
        IO.print("HEAD");
    }

    public void delete(int val){
        Node node = head;
        if(node == null) return;

        if(node.val == val){
            head = head.next;
            tail.next = head;
            return;
        }

        do{
            Node n = node.next;
            if(n.val == val){
                node.next = n.next;
                if(n == tail){
                    tail = node;
                }
                break;
            }
            node = node.next;
        }while(node != head);
    }

    private class Node{
        int val;
        Node next;

        public Node(int val){
            this.val = val;
        }
    }
}
