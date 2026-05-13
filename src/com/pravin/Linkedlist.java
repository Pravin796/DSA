package com.pravin;

public class Linkedlist {
 private Node head;
 private Node tail;
 private int size;

 public Linkedlist(){
     this.size = 0;
 }

 public void insertfirst(int val){
     Node node = new Node(val);
     node.next = head;
     head = node;

     if(tail == null){
         tail = head;
     }
     size += 1;
 }

 public void insertLast(int val){
     if(tail == null){
      insertfirst(val);
      return;
     }

     Node node = new Node(val);
     tail.next = node;
     tail = node;
     size++;
 }

 public int removeFirst(){
     int val = head.data;
     head = head.next;
     if(head == null){
         tail = null;
     }
     size--;
     return val;
 }


    public Node getll(int val){
     Node num = head;
     for(int i=0;i<val;i++){
         if(num == null) return null;
         num = num.next;
     }
//     IO.println((Integer) num.data);
     return num;
    }

    public boolean set(int indx, int val){
     Node node = getll(indx);
     if(node != null){
         node.data = val;
         return true;
     }
     IO.println("here the linked list is empty please use inserfirst or insert");
     return false;
    }

    public int removeLast(){
     if(size <= 0){
         return removeFirst();
     }

     Node seclastval = getll(size - 2);
     int val = seclastval.data;
     tail = seclastval;
     seclastval.next = null;

     size--;
     return val;
    }

    public boolean insert(int idx, int val){
     if(idx < 0 || idx > size) return false;
     if(idx == 0){
         insertfirst(val);
         return true;
     }

     if(idx == size){
         insertLast(val);
         return true;
     }
     Node node = new Node(val);
     Node temp = getll(idx - 1);
     node.next = temp.next;
     temp.next = node;
     size++;
     return true;
    }

    public Node insertRecur(int val, int indx){
      head = insert(head, val, indx);
      return head;
    }

    public Node insert(Node head, int val, int idx){
     if(idx == 0){
         Node node = new Node(val);
         node.next = head;
         size++;
         return node;
     }

        if(head == null){
            System.out.println("Index out of bounds");
            return null;
        }

     head.next = insert(head.next, val, idx-1);
     return head;
    }

    public boolean remove(int idx){
     if(idx < 0 || idx > size) return false;
     if(idx == 0){
         removeFirst();
         return true;
     }

     if(idx == size-1){
         removeLast();
         return true;
     }

     Node pre = getll(idx - 1);
     Node temp = pre.next;

     pre.next = temp.next;
     temp.next = null;

     size--;
     return true;
    }

    public Node find(int val){
     Node node = head;
     int index = 0;
     while(node != null){
         if(node.data == val){
             IO.println("value: "+node.data+" at index: "+index);
            return node;
         }
         node = node.next;
         index++;
     }

     IO.println("not found");
     return null;
     
    }

//    question remove duplicate leetcode 83
    public void removeduplicate(){
     Node node = head;
      while (node.next != null){
          if(node.data == node.next.data) {
              node.next = node.next.next;
              size--;
          }else{
              node = node.next;
          }
      }
      tail = node;
      tail.next = null;
    }

//    question 21 merge two sorted list
    public static Linkedlist merge(Linkedlist first, Linkedlist sec){
     Node f = first.head;
     Node s = sec.head;

     Linkedlist ans = new Linkedlist();
     while (f != null && s != null){
         if(f.data < s.data){
             ans.insertLast(f.data);
             f = f.next;
         }else{
             ans.insertLast(s.data);
             s = s.next;
         }
     }

     while (f != null){
         ans.insertLast(f.data);
         f = f.next;
     }

     while (s != null){
         ans.insertLast(s.data);
         s = s.next;
     }
     return ans;
    }

//    q 141 Linked list cycle
public boolean hasCycle(Node list) {
    Node f = head;
    Node s = head;
    while(f != null && f.next != null){
        s = s.next;
        f = f.next.next;

        if(s == f) return true;
    }
    return false;
}

//length of cycle
public int LengthCycle(Node list) {

    Node f = head;
    Node s = head;
    while(f != null && f.next != null){
        s = s.next;
        f = f.next;

        if(s == f) {
         Node temp = s;
         int length = 0;
         do{
             temp = temp.next;
             length++;
         }while (temp != s);
         return length;
        }
    }
    return 0;
}

 public void display(){
     Node temp = head;
     while(temp != null){
         IO.print(temp.data + " -> ");
         temp = temp.next;
     }
     IO.println("END");
 }

  private class Node{
      private int data;
      private Node next;

      public Node(int data){
          this.data = data;
      }

      public Node(int data, Node next){
          this.data = data;
          this.next = next;
      }
  }

}
