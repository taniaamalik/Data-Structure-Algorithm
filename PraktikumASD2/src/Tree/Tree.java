package tree;

class Nodee {

    int data;
    Nodee left, right;
}

public class Tree {

    Nodee root;

    private Nodee newnode(int data) {
        Nodee n = new Nodee();
        n.data = data;
        return n;
    }

    private Nodee insert(Nodee root, int data) {
        if (root == null) {
            return newnode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Nodee findSuccessor(Nodee root) {
        Nodee n = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return n;
    }

    private Nodee delete(Nodee root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        }
        if (data > root.data) {
            root.right = delete(root.right, data);
        }
        if (data == root.data) {
            if (root.left == null || root.right == null) {
                Nodee temp = null;
                temp = root.left == null ? root.right : root.left;
                return temp;
            }
            Nodee successor = findSuccessor(root);
            root.data = successor.data;
            root.right = delete(root.right, root.data);

        }
        return root;
    }

    void delete(int data) {
        root = delete(root, data);
    }

    public void postOrder(Nodee root) {
        if (root == null) {
            return;
        }
       
        postOrder(root.left);
        postOrder(root.right);
         System.out.print(root.data+" ");
    }

    public void postOrder() {
        postOrder(root);
    }

    public void inOrder(Nodee root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }

    public void inOrder() {
        inOrder(root);
    }

    public void preOrder(Nodee root) {
        if (root == null) {
            return;
        }
  System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
      
    }

    public void preOrder() {
        preOrder(root);
    }

    public static void main(String[] args) {
        Tree t = new Tree();
         /* Let us create following BST 
		5 0 
		/ \ 
	      30   70 
	     /  \  / \ 
	    20  40 60 80 */
        t.insert(50);
        t.insert(30);
        t.insert(20);
        t.insert(40);
        t.insert(70);
        t.insert(60);
        t.insert(80);
       
      t.delete(20);
        System.out.println("post Order : ");
        t.postOrder();
        System.out.println("");
        System.out.println("In Order :");
        t.inOrder();
        System.out.println("");
        System.out.println("pre order :");
        t.preOrder();
    }
}
