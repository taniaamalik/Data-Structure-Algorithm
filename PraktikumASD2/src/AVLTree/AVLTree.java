package AVLTree;

public class AVLTree {

    Node akar;

    int getTinggi(Node N) {
        return (N != null) ? N.tinggi : 0;
    }
// Fungsi untuk memutar node melalui y 
// Lihat diagram diatas 

    Node putarKanan(Node y) {
        Node x = y.nodeKiri;
        Node T2 = x.nodeKanan;
// Melakukan putaran 
        x.nodeKanan = y;
        y.nodeKiri = T2;
// Update tinggi 
        y.tinggi = Math.max(getTinggi(y.nodeKiri), getTinggi(y.nodeKanan)) + 1;
        x.tinggi = Math.max(getTinggi(x.nodeKiri), getTinggi(x.nodeKanan)) + 1;
// hasilkan pasangan node baru 
        return x;
    }
// Fungsi untuk memutar node melalui x 
// Lihat diagram diatas 

    Node putarKiri(Node x) {
        Node y = x.nodeKanan;
        Node T2 = y.nodeKiri;
// Melakukan putaran 
        y.nodeKiri = x;
        x.nodeKanan = T2;
// Update tinggi 
        x.tinggi = Math.max(getTinggi(x.nodeKiri), getTinggi(x.nodeKanan)) + 1;
        y.tinggi = Math.max(getTinggi(y.nodeKiri), getTinggi(y.nodeKanan)) + 1;
// hasilkan pasangan node baru 
        return y;
    }
// Dapatkan nilai seimbang dari node N 

    int getBalance(Node N) {
        return (N != null) ? getTinggi(N.nodeKiri) - getTinggi(N.nodeKanan) : 0;
    }

    Node insert(Node node, int data) {
        /* 1. Penambahan Node pada BST biasa */
        if (node == null) {
            return (new Node(data));
        }
        if (data < node.data) {
            node.nodeKiri = insert(node.nodeKiri, data);
        } else if (data > node.data) {
            node.nodeKanan = insert(node.nodeKanan, data);
        } else // Duplicate datas not allowed 
        {
            return node;
        }
        /* 2. Update tinggi pada ancestor node */
        node.tinggi = 1 + Math.max(getTinggi(node.nodeKiri),
                getTinggi(node.nodeKanan));
        /* 3. Melakukan keseimbangan pada melalui nilai 
ancestor untuk mengecek apakah node tidak 
seimbang*/
        Node result = balance(node, data);
// hasilkan pasangan node baru 
        return result;
    }

    Node balance(Node node, int data) {
        int balance = getBalance(node);
// Apabila kondisi tidak seimbang maka terjadi rotasi 
// Kondisi putar kanan 
        if (balance > 1 && data < node.nodeKiri.data) {
            return putarKanan(node);
        } // Kondisi putar kiri 
        else if (balance < -1 && data > node.nodeKanan.data) {
            return putarKiri(node);
        } // Kondisi putar kiri kanan 
        else if (balance > 1 && data > node.nodeKiri.data) {
            node.nodeKiri = putarKiri(node.nodeKiri);
            return putarKanan(node);
        } // Kondisi putar kanan kiri 
        else if (balance < -1 && data < node.nodeKanan.data) {
            node.nodeKanan = putarKanan(node.nodeKanan);
            return putarKiri(node);
        } // Kondisi tidak berubah sama sekali 
        else {
            return node;
        }
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.nodeKiri);
            System.out.print(node.data + " ");
            inOrder(node.nodeKanan);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.nodeKiri);
            preOrder(node.nodeKanan);
        }
    }

    public Node Find(Node akar, int data) {
        if (akar == null) {
            System.out.println("Data tidak ditemukan");
            return akar;
        }
        if (data < akar.data) {
            return Find(akar.nodeKiri, data);
        } else if (data > akar.data) {
            return Find(akar.nodeKanan, data);
        } else {
            System.out.println("Data ditemukan");
            return akar;
        }
    }

    public int getMinValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        if (node.nodeKiri == null) {
            return node.data;
        }
        return getMinValue(node.nodeKiri);
    }

    public void delete(int data) {
        akar = delete(this.akar, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            System.out.println("Data tidak ada");
            return null;
        }
        if (data < node.data) {
            node.nodeKiri = delete(node.nodeKiri, data);
        } else if (data > node.data) {
            node.nodeKanan = delete(node.nodeKanan, data);
        } else {
            if (node.nodeKiri == null) {
                node = node.nodeKanan;
            } else if (node.nodeKanan == null) {
                node = node.nodeKiri;
            } else {
                int temp = getMinValue(node.nodeKanan);
                node.data = temp;
                node.nodeKanan = delete(node.nodeKanan, temp);
            }
            if (node == null) {
                return null;
            }
        }
        node.tinggi = 1 + Math.max(getTinggi(node.nodeKiri), getTinggi(node.nodeKanan));
        return node;
    }
}