import java.util.Vector;

public class BST{

    static class Node{
        int data;
        Node left, right;

        Node(int val){
        this.data = val;
        }
    }

    Node insert(Node root, int val){
        if(root == null) return new Node(val);

        if(val < root.data){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    Node build(int arr[]){
        Node root = null;

        for(int val: arr){
            root = insert(root, val);
        }

        return root;
    }

    void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }


    public static void main(String[] args){
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {6, 7, 8, 8};

        BST tree = new BST();
        
        Node root1 = tree.build(arr1);

        tree.inOrder(root1);

        System.out.println("Ready code");
    }
}