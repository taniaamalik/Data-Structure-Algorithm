package BAB11_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class AdjacencyMatrixGraph {

    private Node[] node;
    private int size;
    private ArrayList<Integer> listVisited;

    public AdjacencyMatrixGraph(int size) {
        this.size = size;
        node = new Node[size];
        for (int i = 0; i < size; i++) {
            node[i] = null;
        }
    }

    public void addAdj(int x, int y) {
        Node n = new Node(y, node[x]);
        node[x] = n;
    }

    public void addAdj(int x, int y, int jarak) {
        Node n = new Node(y, node[x], jarak);
        node[x] = n;
    }

    public int[][] toAdjMatrix() {
        int[][] adjMatx = new int[size][size];
        for (int i = 0; i < size; i++) {
            Node temp = node[i];
            while (temp != null) {
                adjMatx[i][temp.getDt()] = temp.getJarak();
                temp = temp.getNext();
            }
        }
        return adjMatx;
    }

    public int getInEdges(int x) {
        int temp[][] = toAdjMatrix();
        int total = 0;
        for (int i = 0; i < size; i++) {
            if (temp[i][x] != 0) {
                total++;
            }
        }
        return total;
    }

    public int getOutEdges(int x) {
        int total = 0;
        Node temp = node[x];
        while (temp != null) {
            total++;
            temp = temp.getNext();
        }
        return total;
    }

    //method untuk mendapatkan tetangga dari node x
    public void getNeigborhood(int x) {
        System.out.print("\nTetangga dari node " + x + " adalah: ");
        int temp[][] = toAdjMatrix();
        for (int i = 0; i < size; i++) {
            if (temp[i][x] != 0) {
                System.out.print(i + " ");
            }
        }
        for (int j = 0; j < size; j++) {
            if (temp[x][j] != 0) {
                if (temp[x][j] != temp[j][x]) {
                    System.out.print(j + " ");
                }
            }
        }
    }

    //penelusuran dengan bfs
    void bfs(int nodeAwal) {
        listVisited = new ArrayList<Integer>();
        System.out.print("\npenelusuran BFS dimulai dari " + nodeAwal + " : ");
        Queue<Node> bfsQ = new LinkedList<Node>();
        System.out.print(nodeAwal + " ");
        listVisited.add(nodeAwal);
        bfsQ.add(node[nodeAwal]);
        while (!bfsQ.isEmpty()) {
            Node temp = bfsQ.poll();
            while (temp != null) {
                if (!listVisited.contains(temp.getDt())) {
                    System.out.print(temp.getDt() + " ");
                    listVisited.add(temp.getDt());
                    bfsQ.add(node[temp.getDt()]);
                }
                temp
                        = temp.getNext();
            }
        }
    }

    //penelusuran dengan dfs
    void dfs(int nodeAwal) {
        listVisited = new ArrayList<Integer>();
        System.out.print("\npenelusuran DFS dimulai dari " + nodeAwal + " : ");
        dfsR(nodeAwal);
        System.out.println();
    }

    private void dfsR(int nodeAwal) {
        System.out.print(nodeAwal + " ");
        if (listVisited.contains(nodeAwal)) {
            return;
        } else {
            listVisited.add(nodeAwal);
        }
        Node temp = node[nodeAwal];
        while (temp != null) {
            if (!listVisited.contains(temp.getDt())) {
                dfsR(temp.getDt());
            }
            temp = temp.getNext();
        }
    }

    //method untuk menghitung jarak terpendek dari suatu node x ke node y
    void shortestPath(int x, int y) {
        int mtx[][] = toAdjMatrix();
        int dist[] = new int[size];
        boolean shortPathArr[] = new boolean[size];
        for (int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
            shortPathArr[i] = false;
        }
        dist[x] = 0;
        for (int i = 0; i < size - 1; i++) {
            int idx = getMinIndex(dist, shortPathArr);
            shortPathArr[idx] = true;
            for (int j = 0; j < size; j++) {
                if (!shortPathArr[j] && mtx[i][j] != 0 && dist[i] + mtx[i][j] < dist[j]) {
                    dist[j] = dist[i] + mtx[i][j];
                }
            }
        }
        System.out.println("Jarak terpendek dari node " + x + " ke " + y + " adalah : " + dist[y]);
    }

    int getMinIndex(int dist[], boolean shortPathArr[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < size; i++) {
            if (shortPathArr[i] == false
                    && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void cetakAdjMatrix() {
        int[][] adjMatx = toAdjMatrix();
        System.out.print("\nJarak Node direpresentasikan dengan Matrix Adjacency : \n  |  ");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " | [");
            for (int j = 0; j < size; j++) {
                System.out.print(" " + adjMatx[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public void cetak() {
        for (int i = 0; i < size; i++) {
            System.out.print("[" + i + "]");
            Node n = node[i];
            while (n != null) {
                System.out.print("->" + n.getDt());
                n = n.getNext();
            }
            System.out.println();
        }
    }

    public static void main(String s[]) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(8);
        graph.addAdj(0, 1, 2);
        graph.addAdj(0, 4, 4);
        graph.addAdj(1, 0, 2);
        graph.addAdj(1, 2, 3);
        graph.addAdj(1, 3, 4);
        graph.addAdj(2, 5, 2);
        graph.addAdj(3, 1, 4);
        graph.addAdj(3, 5, 8);
        graph.addAdj(3, 7, 4);
        graph.addAdj(4, 2, 6);
        graph.addAdj(4, 6, 2);
        graph.addAdj(6, 4, 2);
        graph.addAdj(6, 7, 1);
        graph.addAdj(7, 5, 2);
        graph.cetak();
        graph.cetakAdjMatrix();
        graph.getNeigborhood(0);
        graph.getNeigborhood(1);
        graph.getNeigborhood(2);
        graph.getNeigborhood(3);
        graph.getNeigborhood(4);
        graph.getNeigborhood(5);
        graph.getNeigborhood(6);
        graph.getNeigborhood(7);
        graph.bfs(0);
        graph.dfs(0);
        graph.shortestPath(0, 7);
        graph.shortestPath(1, 5);
    }
}