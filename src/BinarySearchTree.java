import java.util.Comparator;

public class BinarySearchTree<T> {
    Comparator<? super T> comp;
    Node root;

    public BinarySearchTree(Comparator<? super T> comp) {
        this.comp = comp;
        root = null;
    }

    private class Node {
        Node left, right;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }

    public boolean insert(T value) {
        root = insertRecursive(value, root);
        return true;
    }

    private Node insertRecursive(T value, Node curr) {
        if (curr == null) {
            return new Node(value);
        }
        int cmpVal = comp.compare(value, curr.value);
        if (cmpVal < 0) {
            curr.left = insertRecursive(value, curr.left);
        } else {
            curr.right = insertRecursive(value, curr.right);
        }
        return curr;
    }
}
