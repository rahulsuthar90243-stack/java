import java.util.Vector;

class predSucc{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    Node rihgtMostInLeft(Node root){
        Node ans = null;
        while(root != null){
            ans = root;
            root = root.left;
        }
        return ans;
    }

    Node leftMostInRight(Node root){
        Node ans = null;
        while(root != null){
            ans = root;
            root = root.right;
        }
        return ans;
    }

    Vector<Integer> getPredSucc(Node root, int key){
        Node curr = root;
        Node pred = null;
        Node succ = null;

        while(curr != null){

            if(key < curr.data){
                succ = curr;
                curr = curr.left;
            }
            else if(key > curr.data){
                pred = curr;
                curr = curr.right;
            }
            else{
                if(curr.left != null){
                 pred = rihgtMostInLeft(curr.left);
                }
                if(curr.right != null){
                succ = leftMostInRight(curr.right);
                }
                break;
            }
        }

        Vector<Integer> result = new Vector<>();
        result.add(pred.data);
        result.add(succ.data);
        return result;
        // Vector<Integer> result = new Vector<>();
        // result.add(pred != null ? pred.data : -1);  // or some sentinel / handle separately
        // result.add(succ != null ? succ.data : -1);
        // return result;
    }

    public static void main(String[] args){

        predSucc solve = new predSucc();

        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        int key = 7;
        Vector<Integer> ans = solve.getPredSucc(root, key);

        System.out.println("Predecessor: " + ans.get(0));
        System.out.println("Successor: " + ans.get(1));
    }
}