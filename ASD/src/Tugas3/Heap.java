package Tugas3;

public class Heap {

    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;

        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public int removeFirst() {
        System.out.println("Menghapus angka " + Heap[FRONT] + ":");
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        Heap[size+1]=0;
        maxHeapify(FRONT);
        return popped;
    }

    public int removeLast() {
        System.out.println("Menghapus angka " + Heap[size] + ":");
        int popped = Heap[maxsize];
        Heap[maxsize] = Heap[size--];
        Heap[size+1]=0;
        return Heap[maxsize] = 0;
    }

    public int remove(int x) {
        System.out.println("Menghapus angka " + x + ":");
        int popped = 0;
        for (int i = 1; i < maxsize; i++) {
            if (Heap[i] == x) {
                popped = Heap[i];
                Heap[i] = Heap[size--];
                Heap[size+1]=0;
                maxHeapify(i);
            }
        }
        return popped;
    }

    public static void main(String... arg) {
        Heap heap = new Heap(9);
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);
        heap.print();
        System.out.println("==============================================");
        heap.remove(22);
        heap.print();
        System.out.println("==============================================");
        heap.removeLast();
        heap.print();
        System.out.println("==============================================");
        heap.removeFirst();
        heap.print();
        System.out.println("==============================================");
        heap.remove(9);
        heap.print();
    }
}