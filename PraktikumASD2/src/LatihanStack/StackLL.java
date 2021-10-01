package LatihanStack;

public class StackLL<T> {
    class Node{
        T data;
        Node pointer;
    }
    Node head,tail,top;
    
    boolean isEmpty(){
        Node n = new Node();
        head=tail=top=n;
    }
    
    void push(T data){
        
    }
    
    T pop(){
        T.data =  top.data;
        
        node n = head;
        
        if(isEmpty()){
            throw new StackOverflowError("data kosong");
        }
        if(head==tail){
            head=tail=top=null;
            return data;
        }
        
        while (n.pointer!=taill){
            n = n.pointer;
        }
        
        n.pointer = null;
        tail=n;
        top=tail;
        
        return data;
        }
    T peek(){
        return top.data;
    }
    
    public static void main(String[] args) {
        StackLL<Integer> s = new StackLL<>();
        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        
    }
}
