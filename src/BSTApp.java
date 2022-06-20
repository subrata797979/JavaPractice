class Node {
    int data;
    Node left;
    Node right;
    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class BST {
    public Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }
        if(val<root.data)
            root.left = insert(root.left,val);
        else
            root.right = insert(root.right,val);
        return root;
    }

    public void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public boolean search(int key, Node root) {
        if(searchUtil(key,root)==null)
            return false;
        return true;
    }

    public Node searchUtil(int key, Node root) {
        if(root == null | (root!=null && root.data == key)) return root;
        if(key<root.data)
            return searchUtil(key,root.left);
        return searchUtil(key,root.right);
    }
}

public class BSTApp {
    public static void main(String[] args) {
        System.out.println("BST");
        BST a = new BST();
        Node root = null;
        root = a.insert(root,8);
        root = a.insert(root,9);
        root = a.insert(root,7);
        root = a.insert(root,10);
        a.inorder(root);
        System.out.println(a.search(9,root));
        System.out.println(a.search(10,root));
        System.out.println(a.search(11,root));
        root = a.insert(root,11);
        System.out.println(a.search(11,root));
        a.inorder(root);
    }
}