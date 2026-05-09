package com.pravin;

public class Dll {

    private Node head;
    public int length;

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
        length++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        Node last = head;
        node.next = null;
        if(head == null){
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null){
            last = last.next;
        }

        last.next = node;
        node.prev = last;
        length++;
    }

    public boolean insertAt(int indx, int val) {
        Node before = get(indx - 1);

        if(before == null) {
            IO.println("doent exist");
            return false;
        }
        Node node = new Node(val);
        node.next = before.next;
        before.next = node;
        node.prev = before;
        if(node.next != null){
            node.next.prev = node;
        }

        return false;
    }

    public Node get(int indx){
        Node node = head;
        for(int i=0;i<indx;i++){
            if(node.next == null) return null;
            node = node.next;
        }
//        IO.println((Integer) node.data);
        return node;
    }

    public Node find(int val){
        Node node = head;
        while(node.next != null){
            if(node.data == val){
                return node;
            }
           node = node.next;
        }

        return null;
    }

    public void display(){
        Node node = head;
        Node last = null;
        while(node != null){
            IO.print(node.data + " -> ");
            last = node;
            node = node.next;
        }
        IO.println("END");

        IO.println("Print from last");
        while(last != null){
            IO.print(last.data + " -> ");
            last = last.prev;
        }

        IO.println("START");
    }


    private  class Node{
          int data;
          Node next;
          Node prev;

          public Node(int val){
               this.data = val;
          }
    }
}
