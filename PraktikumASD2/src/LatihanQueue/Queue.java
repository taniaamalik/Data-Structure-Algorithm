package LatihanQueue;

public class Queue<T> {
    class Node{
        T.data;
        Node pointer;
    }
    Node front,rear;
    
    booelan isEmpty() {
        Node n = new Node();
        front=rear=n;
    }
    
    void enque(T data){
        Node n = new Node();
        n.data = data;
        
        if(isEmpty()){
            front=rear=n;
            
        }else{
            rear.ponter = n;
            rear=n;
        }
    }
    T deque(){
        T.data = front.data;
        
        while(front.pointer!=null){
        front = front.pointer;
        }
        
        return data;
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        
        System.out.println(q.deque());
        System.out.println(q.deque());
    }
}
