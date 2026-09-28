public class Main {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class Info {
        int min;
        int max;
        int size;

        Info(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static Info helper(Node root) {

        if (root == null) {
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (root.val > left.max && root.val < right.min) {

            int currMIN = Math.min(root.val, left.min);
            int currMAX = Math.max(root.val, right.max);
            int currSize = left.size + right.size + 1;

            return new Info(currMIN, currMAX, currSize);
        }

        else {
            return new Info(
                Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Math.max(left.size, right.size)
            );
        }
    }

    static int largestBst(Node root) {

        Info info = helper(root);

        return info.size;
    }

    public static void main(String[] args) {

        Node root = new Node(50);

        root.left = new Node(30);
        root.right = new Node(60);

        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right.left = new Node(45);
        root.right.right = new Node(70);

        int largestBST = largestBst(root);

        System.out.println("Largest BST: " + largestBST);
    }
}