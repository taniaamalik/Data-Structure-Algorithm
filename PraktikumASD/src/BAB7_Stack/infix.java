package BAB7_Stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class infix {

    class Stack {

        private int size, top;
        private char[] data;

        public Stack(int n) {
            size = n;
            data = new char[size];
            top = -1;
        }

        public void push(char j) {
            data[++top] = j;
        }

        public char pop() {
            return data[top--];
        }

        public boolean isEmpty() {
            return (top == -1);
        }
    }
    private Stack stack;
    private String inp;
    private String out = "";

    public infix(String in) {
        inp = in;
        int size = inp.length();
        stack = new Stack(size);
    }

    public void operator(char a, int b) {
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                stack.push(top);
                break;
            } else {
                int urutan;
                switch (top) {
                    case '+':
                    case '-':
                        urutan = 1;
                        break;
                    case '*':
                    case '/':
                        urutan = 2;
                        break;
                    default:
                        urutan = 3;
                        break;
                }
                if (urutan < b) {
                    stack.push(top);
                    break;
                } else {
                    out = out + top;
                }
            }
        }
        stack.push(a);
    }

    public void awal(char ch) {
        while (!stack.isEmpty()) {
            char ch2 = stack.pop();
            if (ch2 == '(') {
                break;
            } else {
                out = out + ch2;
            }
        }
    }

    public String konversi() {
        for (int j = 0; j < inp.length(); j++) {
            char a = inp.charAt(j);
            switch (a) {
                case '+':
                case '-':
                    operator(a, 1);
                    break;
                case '*':
                case '/':
                    operator(a, 2);
                    break;
                case '^':
                    operator(a, 3);
                    break;
                case '(':
                    stack.push(a);
                    break;
                case ')':
                    awal(a);
                    break;
                default:
                    out = out + a;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            out = out + stack.pop();
        }
        return out;
    }

    class Node2 {

        Object data;
        Node2 next;

        Node2(Object data) {
            this.data = data;
        }
    }
    private Node2 head, tail, top;

    public infix() {
        head = tail = top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object dataPop = top.data;
        removeLast();
        top = tail;
        return dataPop;
    }

    private void removeLast() {
        Node2 temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
        }
    }

    public void push(Object dt) {
        addLast(dt);
        top = tail;
    }

    private void addLast(Object dt) {
        Node2 newNode = new Node2(dt);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Object peek() {
        return top.data;
    }

    public int hitungPostfix(String pf) {
        char angka[] = pf.toCharArray();
        infix sll = new infix();
        int hasil = 0;
        int temp;
        int a, b;
        for (int i = angka.length - 1; i >= 0; i--) {
            if (angka[i] == '+' || angka[i] == '-' || angka[i] == '*' || angka[i] == '/') {
                sll.push(angka[i]);
                angka[i] = '~';
            }
        }
        while (!sll.isEmpty()) {
            for (int j = 0; j < angka.length - 1; j += 3) {
                if (angka[j + 1] != '~') {
                    a = (int) angka[j] - 48;
                    b = (int) angka[j + 1] - 48;
                    char operator = (char) sll.peek();
                    switch (operator) {
                        case '+':
                            hasil += a + b;
                            break;
                        case '-':
                            hasil += a - b;
                            break;
                        case '*':
                            hasil += a * b;
                            break;
                        default:
                            hasil += a / b;
                            break;
                    }
                    sll.pop();
                } else {
                    temp = hasil;
                    a = (int) angka[j] - 48;
                    if (sll.peek().equals('+')) {
                        hasil = temp + a;
                    } else if (sll.peek().equals('-')) {
                        hasil = temp - a;
                    } else if (sll.peek().equals('*')) {
                        hasil = temp * a;
                    } else {
                        hasil = temp / a;
                    }
                    sll.pop();
                }
            }
        }
        return hasil;
    }

    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        System.out.print("Masukkan Notasi Infix : ");
        String input = i.nextLine();
        String output;
        infix hasil = new infix(input);
        output = hasil.konversi();
        System.out.println("==============================");
        System.out.println("Hasil Konversi Postfix : " + output);
        infix postfix = new infix();
        System.out.println("Hasil Hitungan Postix : " + postfix.hitungPostfix(output));
    }
}