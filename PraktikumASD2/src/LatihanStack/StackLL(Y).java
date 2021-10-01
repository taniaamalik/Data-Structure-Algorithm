/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAB7;


public class StackLL<T> {
    class Node {
       T data;
       Node pointer;
    }
    Node head, tail, top;
    boolean isEmpty(){
        return head==null;
    }
   
    void push (T data){
      Node n=new Node();
      n.data=data;
      if(this.isEmpty()){
          head=tail=top;
      }
      else{
          tail.pointer=n;
          tail=n;
          top=tail;
      }
    }
    T pop(){
        T data=top.data;
        Node n=head;
        if(this.isEmpty()){
            throw new StackOverflowError("data kosong");
        }
        if(head==tail){
            head=tail=null;
            return data;
        }
        while(n.pointer!=tail){
            n=n.pointer;
        }
        n.pointer=null;
        tail=n;
        top=tail;
        return data;
    }
    T peek(){
        return top.data;
    }
      public static void main(String[] args) {  
        StackLL<Integer> s= new StackLL<>();
        s.push(1);
        s.push(2);
        s.push(3);
//          System.out.println(s.pop());
            System.out.println(s.pop());
            System.out.println(s.pop());
    }
     
}
