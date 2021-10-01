package RR;

public class Queue {

    private List listAntrian;

    public Queue() {
        listAntrian = new List("queue");
    }

    public void enqueue(Object object) {
        listAntrian.sisipDiAkhir(object);
    }

    public Object dequeue() {
        return listAntrian.hapusDrDepan();
    }

    public boolean kosong() {
        return listAntrian.kosong();
    }

    public void cetak() {
        listAntrian.cetak();
    }

    public void RoundRobin(int quantumtime) {
        listAntrian.RoundRobin(quantumtime);
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.enqueue(2);
        q.cetak();
        q.enqueue(3);
        q.cetak();
        q.enqueue(1);
        q.cetak();
        q.enqueue(4);
        q.cetak();
        q.RoundRobin(1);
    }
}