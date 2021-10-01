/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class Queue <T>{
    class Node {
        T data;
        Node pointer;
        
    }
    Node front,rear;
    boolean isEmpty(){
        return front==null;
    }
    void enqueue(T data){
       Node n=new Node();
       n.data=data;
       if(this.isEmpty()){
           front =rear=n;
           
       }else{
           rear.pointer=n;
           rear=n;
       }
    }
    T dequeue(){
        T data=front.data;
       if(front.pointer!=null){
            front=front.pointer;
        }
       
        return data;
    }
    public static void main(String[] args) {
        Queue<Integer> q=new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
