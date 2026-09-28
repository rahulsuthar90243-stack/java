import java.util.Vector;
import java.util.Arrays;
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BSTIterator {
    private Stack<Node> s = new Stack<>();

    private void storeLeftNode(Node root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public BSTIterator(Node root) {
        storeLeftNode(root);
    }

    public int next() {
        Node ans = s.pop(); // remove the node
        if (ans.right != null) {
            storeLeftNode(ans.right); // go to right subtree
        }
        return ans.val;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}

public class vectorToBST {

    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        Vector<Integer> arr = new Vector<>(Arrays.asList(7, 3, 15, 9, 20));

        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }

        System.out.println("BST root value: " + root.val);

        // Example use of iterator
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}