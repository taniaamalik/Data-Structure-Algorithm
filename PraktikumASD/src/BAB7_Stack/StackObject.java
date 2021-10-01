package BAB7_Stack;

public class StackObject {

    public static void main(String[] args) {
        //implementasi Stack
        Stack st = new Stack();
        st.push(new Double(5));
        st.push(new Double(8));
        st.push(new Double(7));
        while (!st.empty()) {
            System.out.println(st.pop());
        }
        Stack stBuku = new Stack();
        stBuku.push(new Book("Java"));
        stBuku.push(new Book("Algoritma dan STD"));
        stBuku.push(new Book("C++"));
        System.out.println(stBuku.peek());
        while (!stBuku.empty()) {
            System.out.println(stBuku.pop());
        }
    }
}